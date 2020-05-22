@Override
public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
    try {
        Message message = (Message) e.getMessage();
        Method method = messageHandlers.get(message.getClass());
        if (method == null) {
            System.out.println("No handler for message!");
        } else {
            method.invoke(this, ctx, message);
        }
    } catch(Exception exception) {
        exception.printStackTrace();
    }
}