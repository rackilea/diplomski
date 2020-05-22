public static void invokeChannelReadNow(final ChannelHandlerContext ctx, final Object msg) {
    try {
        ((AbstractChannelHandlerContext) ctx).invokedThisChannelRead = true;
        ctx.handler().channelRead(ctx, msg); // -> calls messageReceived
    } catch (Throwable t) {
        notifyHandlerException(ctx, t);      // -> calls exceptionCaught
    }
}