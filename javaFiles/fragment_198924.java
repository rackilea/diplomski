EventLoopGroup bossGroup = new NioEventLoopGroup(numBossThreads);
EventLoopGroup workerGroup = new NioEventLoopGroup(numWorkerThreads);
ServerBootstrap sb1 = null;
ServerBootstrap sb2 = null;
ServerBootstrap sb3 = null;
ChannelFuture cf1 = null;
ChannelFuture cf2 = null;
ChannelFuture cf3 = null;
try {
    sb1 = new ServerBootstrap();
    sb1.group(bossGroup, workerGroup);
    ...
    cf1 = sb1.bind();

    sb2 = new ServerBootstrap();
    sb2.group(bossGroup, workerGroup);
    ...
    cf2 = sb2.bind();

    sb3 = new ServerBootstrap();
    sb3.group(bossGroup, workerGroup);
    ...
    cf3 = sb3.bind();
} finally {
    // Now waiting for the parent channels (the binded ones) to be closed
    if (cf1 != null) {
        cf1.sync().channel().closeFuture().sync();
    }
    if (cf2 != null) {
        c2.sync().channel().closeFuture().sync();
    }
    if (cf3 != null) {
        cf3.sync().channel().closeFuture().sync();
    }
    if (b1 != null) {
        b1.shutdownGracefully();
    }
    if (b2 != null) {
        b2.shutdownGracefully();
    }
    if (b3 != null) {
        b3.shutdownGracefully();
    }