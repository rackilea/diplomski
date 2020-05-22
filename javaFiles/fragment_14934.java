public class MyPacketHandler extends SimpleChannelInboundHandler {
    @Override
    public void channelRead0(ChannelHandlerContext ctx, Object msg) {
        if (msg instanceof MsgA) {
            handleA(ctx, (MsgA) msg);
        } else if (msg instanceof MsgB) {
            handleB(ctx, (MsgB) msg);
        } ...
    }

    private void handleA(ChannelHandlerContext ctx, MsgA msg) {
        ...
    }
    ...
}