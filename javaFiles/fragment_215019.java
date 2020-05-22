public class RPCInputHandler extends ReplayingDecoder<Object> {
   RPC upstream = ....;
   protected void decode(ChannelHandlerContext ctx, ByteBuf buf) throws Exception {
      upstream.readPacket(new ByteBufInputStream(buf));
      state(null);
   }
}