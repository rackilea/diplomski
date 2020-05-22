EventLoopGroup bossGroup = new NioEventLoopGroup(numBossThreads);
EventLoopGroup workerGroup = new NioEventLoopGroup(numWorkerThreads);
ServerBootstrap sb1 = null;
ServerBootstrap sb2 = null;
ServerBootstrap sb3 = null;
Channel ch1 = null;
Channel ch2 = null;
Channel ch3 = null;
try {
    sb1 = new ServerBootstrap();
    sb1.group(bossGroup, workerGroup);
    ...
    ch1 = sb1.bind().sync().channel();

    sb2 = new ServerBootstrap();
    sb2.group(bossGroup, workerGroup);
    ...
    ch2 = sb2.bind().sync().channel();

    sb3 = new ServerBootstrap();
    sb3.group(bossGroup, workerGroup);
    ...
    ch3 = sb3.bind().sync().channel();
} finally {
    // Now waiting for the parent channels (the binded ones) to be closed
    if (ch1 != null) {
        ch1.closeFuture().sync();
    }
    if (b1 != null) {
        b1.shutdownGracefully();
    }
    if (ch2 != null) {
        ch2.closeFuture().sync();
    }
    if (b2 != null) {
        b2.shutdownGracefully();
    }
    if (ch3 != null) {
        ch3.closeFuture().sync();
    }
    if (b3 != null) {
        b3.shutdownGracefully();
    }