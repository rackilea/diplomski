public class HttpServerInitializer extends ChannelInitializer<SocketChannel> {
    private final EventExecutorGroup executors = new DefaultEventExecutorGroup(OFFLOAD_THREADS);
    @Override
    public void initChannel(SocketChannel ch) {
        ChannelPipeline p = ch.pipeline();

        p.addLast(new HttpRequestDecoder());
        p.addLast(new HttpResponseEncoder());
        p.addLast(new HttpObjectAggregator(1048576));
        p.addLast(new HttpContentCompressor());
        p.addLast("idleTimeoutHandler", new IdleStateHandler(0, 1, 0));
        p.addLast(executors, new HttpRequestHandler());
    }
}