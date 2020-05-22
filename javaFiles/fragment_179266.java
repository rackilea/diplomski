@Override
protected void decode(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket, List list) throws Exception {
  final Channel channel = channelHandlerContext.channel();
  channel.eventLoop().schedule(() -> {
    final ByteBuf buffer = Unpooled.buffer(64);
    buffer.writeBytes("Hey there".getBytes());
    channel.writeAndFlush(new DatagramPacket(buffer, datagramPacket.sender()));
  }, random.nextInt(sleep), TimeUnit.MILLISECONDS);
}