41      @Override
42      public void channelActive(ChannelHandlerContext ctx) {
43          final Channel inboundChannel = ctx.channel();
44  
45          // Start the connection attempt.
46          Bootstrap b = new Bootstrap();
47          b.group(inboundChannel.eventLoop())
48           .channel(ctx.channel().getClass())
49           .handler(new HexDumpProxyBackendHandler(inboundChannel))
50           .option(ChannelOption.AUTO_READ, false);
51          ChannelFuture f = b.connect(remoteHost, remotePort);
52          outboundChannel = f.channel();
53          f.addListener(new ChannelFutureListener() {
54              @Override
55              public void operationComplete(ChannelFuture future) {
56                  if (future.isSuccess()) {
57                      // connection complete start to read first data
58                      inboundChannel.read();
59                  } else {
60                      // Close the connection if the connection attempt has failed.
61                      inboundChannel.close();
62                  }
63              }
64          });
65      }