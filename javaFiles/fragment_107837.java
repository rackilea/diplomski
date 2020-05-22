public void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) {
    ctx.executor().schedule(new Runnable() {
        @Override
        public void run() {
            // Put your try/catch in here
        }
    }, 5000, TimeUnit.MILLISECONDS);
}