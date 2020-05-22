Bootstrap b = new Bootstrap();
        b.group(new NioEventLoopGroup(), new NioEventLoopGroup())
         .channel(NioServerSocketChannel.class)
         .option(ChannelOption.SO_BACKLOG, 100)
         .handler(new LoggingHandler(LogLevel.INFO))
         .childHandler(new ChannelInitializer<SocketChannel>() {
             @Override
             public void initChannel(SocketChannel ch) throws Exception {
                 try {
                     ch.config().setTrafficClass(0x18);
                 } catch (ChannelException e) {
                     // Ignore
                 }
                 ch.pipeline().addLast(
                         new LoggingHandler(LogLevel.INFO),
                         new EchoServerHandler());
             }
         });