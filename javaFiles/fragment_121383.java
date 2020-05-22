static class UdpHandler extends SimpleChannelInboundHandler<DatagramPacket> {
    private InetSocketAddress lastSender;

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, DatagramPacket packet) throws Exception {
        lastSender = packet.sender();
        throw new RuntimeException();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("Evil sender was: " + lastSender);
    }
}