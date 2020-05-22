package io.netty.example.time;

import java.util.Date;

public class TimeClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        ByteBuf m = (ByteBuf) msg; // Here we are getting the message
        try {
            long currentTimeMillis = (m.readUnsignedInt() - 2208988800L) * 1000L; //** We will always have to write the logic unless there is already a netty handler for it, but even then you may or probably will have to implement business logic handler specific to your application(s)
            System.out.println(new Date(currentTimeMillis));
            ctx.close();  //** you can close a connection on a channel or a ChannelHandlerContext
        } finally {
            m.release(); //** Here you have to release the buffer
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }
}