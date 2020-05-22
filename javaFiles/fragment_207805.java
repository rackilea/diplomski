package com.example.test.app;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.concurrent.ScheduledFuture;

import java.util.concurrent.TimeUnit;

public class ServerHandler extends ChannelInboundHandlerAdapter {

    private ScheduledFuture sf;

    @Override
    public void channelActive(ChannelHandlerContext ctx)
    {
        System.out.println("Someone's connedted! "+ctx.channel());
        sf = ctx.executor().scheduleAtFixedRate(() -> {
            System.out.println("Calling...");
            saySomething(ctx);
        }, 1, 1, TimeUnit.SECONDS);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) {
        System.out.println("Someone's disconnected! "+ctx.channel());
        sf.cancel(false);
    }

    private void saySomething(ChannelHandlerContext ctx)
    {
            final ChannelFuture f = ctx.writeAndFlush("Sup!");
            f.addListener((ChannelFutureListener) (ChannelFuture future) -> {
                System.out.println("Something has been said!");
            });
    }

}