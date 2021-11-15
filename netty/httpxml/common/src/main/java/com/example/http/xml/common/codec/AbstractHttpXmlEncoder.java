package com.example.http.xml.common.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;

public abstract class AbstractHttpXmlEncoder<T> extends MessageToMessageEncoder<T> {

    protected ByteBuf encode0(ChannelHandlerContext ctx, Object body) throws Exception {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        XMLEncoder encoder = new XMLEncoder(out);
        encoder.writeObject(body);
        encoder.close();
        return Unpooled.copiedBuffer(out.toByteArray());
    }
}