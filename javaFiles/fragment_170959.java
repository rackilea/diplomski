public class NettyHttpServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    public void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast("http", new HttpServerCodec());

        // optional, makes life easier
        pipeline.addLast("dechunker", new HttpObjectAggregator(65536)); 

        pipeline.addLast("handler", new HttpServerHandler());
   }
}