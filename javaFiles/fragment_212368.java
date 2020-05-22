NioServerSocketChannelFactory factory = new NioServerSocketChannelFactory(
            Executors.newCachedThreadPool(), Executors.newCachedThreadPool());

    ServerBootstrap bootstrap1 = new ServerBootstrap(factory);
    bootstrap1.setPipelineFactory(...);
    bootstrap1.bind(new InetSocketAddress(port1));

    ServerBootstrap bootstrap2 = new ServerBootstrap(factory);
    bootstrap2.setPipelineFactory(...);
    bootstrap2.bind(new InetSocketAddress(port2));