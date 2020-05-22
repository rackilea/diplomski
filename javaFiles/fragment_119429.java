ServerBootstrap b = new ServerBootstrap(); // (2)
        b.group(bossGroup, workerGroup)
                .channel(NioServerSocketChannel.class) // (3)
                .childHandler(new ChannelInitializer<SocketChannel>() { // (4)
                    @Override
                    public void initChannel(SocketChannel ch) throws Exception {

                        //decrypt  //checknum

                        ch.config().setRecvByteBufAllocator(new FixedRecvByteBufAllocator(2048)); //set  buf size here
                         ch.pipeline().addLast(new InboundDecryptor());
 .
 .
 .