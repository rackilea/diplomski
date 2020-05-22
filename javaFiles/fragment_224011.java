public void start() {
    EventLoopGroup group = new NioEventLoopGroup();

    try {
        Bootstrap bootstrap = new Bootstrap().group(group).channel(NioSocketChannel.class).handler(new ClientAdapterInitializer());

        Channel channel = bootstrap.connect(server, port).sync().channel();

        channel.write("Hi\n");
        channel.write("Hi\n");
        channel.write("Hi\n");
        channel.flush();

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        group.shutdownGracefully();
    }
}