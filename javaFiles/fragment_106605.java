public class MyHandler extends SimpleChannelUpstreamHandler {
    @Override
    public void messageReceived(
        ChannelHandlerContext ctx, MessageEvent e) {


        try {
            String remoteAddress = e.getRemoteAddress().toString();
            ChannelBuffer buffer= (ChannelBuffer) e.getMessage();
            //Now the buffer contains byte stream from client.

        } catch (UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }

        byte[] output; //suppose output is a filled byte array
        ChannelBuffer writebuffer = ChannelBuffers.buffer(output.length);
        for (int i = 0; i < output.length; i++) {
            writebuffer.writeByte(output[i]);
        }


        e.getChannel().write(writebuffer);
    }

    @Override
    public void exceptionCaught(
            ChannelHandlerContext ctx, ExceptionEvent e) {
        // Close the connection when an exception is raised.
        e.getChannel().close();
    }
}