private enum HandlerState { INITIAL, IMEI_RECEIVED; }
private HandlerState state = HandlerState.INITIAL;

@Override
public void messageReceived(ChannelHandlerContext ctx, MessageList<Object> msgs) throws Exception
{

    if (state == HandlerState.INITIAL)
    {
        MessageList<String> imeis = msgs.cast();
        String imei = imeis.get(0);

        ctx.write(Constants.BUS_DATA_ACCEPT);
        state = HandlerState.IMEI_RECEIVED;
    } else
    {
        // Forward message to next handler...
        // Not sure exactly how this is done in Netty 4
        // Maybe: ctx.fireMessageReceived(msgs);
        // Or maybe it is:
        // ctx.nextInboundMessageBuffer().add(msg);
        // ctx.fireInboundBufferUpdated();

        // I believe you could also remove the IMEI handler from the
        // pipeline instead of having it keep state, if it is not going to do anything
        // further.
    }

}