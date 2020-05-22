public class ObjectEchoServerHandler extends xxx {
   ChannelGroup allChannels;
   public ObjectEchoServerHandler(ChannelGroup allChannels) {
      this.allChannels = allChannels;
   }

   @Override
   public void channelActive(ChannelHandlerContext ctx) {
       // closed on shutdown.
       allChannels.add(ctx.channel());
       super.channelActive(ctx);
   }
}