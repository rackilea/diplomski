public class IdleStateAwareHandler extends IdleStateAwareChannelHandler {

    @Override
    public void channelIdle(ChannelHandlerContext ctx, IdleStateEvent e) {
        if (e.getState() == IdleState.READER_IDLE) {
            e.getChannel().write("heartbeat-reader_idle");
        }
        else if (e.getState() == IdleState.WRITER_IDLE) {
            Logger.getLogger(IdleStateAwareHandler.class.getName()).log(
                    Level.WARNING, "WriteIdle detected, closing channel");
            e.getChannel().close();
            e.getChannel().write("heartbeat-writer_idle");
        }
        else if (e.getState() == IdleState.ALL_IDLE) {
            e.getChannel().write("heartbeat-all_idle");
        }
    }
}