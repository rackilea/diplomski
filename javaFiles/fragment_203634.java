@Override
public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
    logger.log(Level.INFO, e.getMessage().toString());
    byte[] message = "Hello over there!".getBytes("UTF-8");

    ChannelBuffer buf = ChannelBuffers.buffer(message.length + 2);
    buf.clear();
    short len = (short)message.length;
    buf.writeShort(len);
    buf.writeBytes(message);
    e.getChannel().write(buf);

    if(!sent){
        //do something and set sent
    }
}