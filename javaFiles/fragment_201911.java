public void start() throws InterruptedException{
        EventLoopGroup group = new NioEventLoopGroup();
        EventExecutorGroup sqlExecutorGroup = new DefaultEventExecutorGroup(10);
        ServerBootstrap server = new ServerBootstrap();
        server.group(group);
        server.channel(NioServerSocketChannel.class);
        server.localAddress(new InetSocketAddress(port));
        server.childHandler(new ChannelInitializer<SocketChannel>(){
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast(new HttpServerCodec());
                    ch.pipeline().addLast(new ChunkedWriteHandler());
                    ch.pipeline().addLast(new HttpObjectAggregator(65536));
                    ch.pipeline().addLast(new WebSocketServerProtocolHandler("/"));
                    ch.pipeline().addLast(new WebSocketFrameToByteBuf());
                    ch.pipeline().addLast(new ProtobufEncoder());
                    ch.pipeline().addLast(new ProtobufDecoder(Chat.MsgWrapper.getDefaultInstance()));
                    ch.pipeline().addLast(sqlExecutorGroup,new MsgUserLogin(prop.getProperty("sessions_prefix")));
           }
        });
        ChannelFuture f = server.bind().sync();
        f.channel().closeFuture().sync();   
    }