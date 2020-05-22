@Override
public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
    if (evt == IdleStateEvent.FIRST_WRITER_IDLE_STATE_EVENT) {
        // Handle the event here
    }
    else {
        super.userEventTriggered(ctx, evt);
    }
}