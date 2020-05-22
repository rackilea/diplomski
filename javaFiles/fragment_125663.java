public class ServerReceiverHandler extends ChannelInboundHandlerAdapter {

    ChannelHandlerContext ctx;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        final ByteBuf buffer = (ByteBuf)msg;
        //prints out String representation of xml doc
        log.info("read : {}" + buffer.toString((CharsetUtil.UTF_8)));
        ReferenceCountUtil.release(msg);
    }
}