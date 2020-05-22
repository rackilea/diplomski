@Override
public void channelActive(ChannelHandlerContext ctx) throws Exception {
    log.info("..sending new server Quote..");
    ChannelFuture cf = ctx.writeAndFlush(nextQuote());
    if (!cf.isSuccess()){
        log.log(Level.SEVERE, cf.toString());
    }
    ctx.fireChannelActive();
}