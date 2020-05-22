public class RPCInputHandler extends SimpleChannelInboundHandler<ByteBuf> {
   RPC upstream = ....;
   PipedInputStream in;
   PipedOutputStream out;

   @Override public void channelActive(ChannelHandlerContext ctx) throws Exception {
       in = new PipedInputStream();
       out = new PipedOutputStream(in);
       upstream.startInput(in);
   }

   @Override public void channelInactive(ChannelHandlerContext ctx) throws Exception {
       out.close(); // This sends EOF to the other pipe
   }

   // This method is called messageReceived(ChannelHandlerContext, I) in 5.0.
   public void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
      byte[] data = new byte[msg.readableBytes()];
      msg.readBytes(data);
      out.write(data);
   }
}