SslContext sslContext = provideSslContext();
 Bootstrap b = new Bootstrap();
 b.group(workerGroup)
        .channel(NioSocketChannel.class)
        .handler(new Channelinitializer(sslContext));

 Channel ch1 = b.connect("localhost", 8008).sync().channel();
 ch1.pipeline.get(SslHandler.class).handshakeFuture().sync()

 Bootstrap b1 = new Bootstrap();
 b1.group(workerGroup)
        .channel(NioSocketChannel.class)
        .handler(new Channelinitializer(sslContext));

 Channel ch2 = b1.connect("localhost", 8009).sync().channel();