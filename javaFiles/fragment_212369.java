@Override
public void channelBound(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
    ctx.getPipeline().addLast("new", new SimpleChannelUpstreamHandler() {
        @Override
        public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
             ...
        }
    });
}