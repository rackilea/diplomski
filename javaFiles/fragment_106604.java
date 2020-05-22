public class TCPListener {
    private static ServerBootstrap bootstrap;

    public static void run(){
        bootstrap = new ServerBootstrap(
                new NioServerSocketChannelFactory(
                        Executors.newCachedThreadPool(),
                        Executors.newCachedThreadPool()));

        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            public ChannelPipeline getPipeline() throws Exception {
                TCPListnerHandler handler = new MyHandler();
                ChannelPipeline pipeline = Channels.pipeline();
                pipeline.addLast("handler", handler);

                return pipeline;
            }
        });

        bootstrap.bind(new InetSocketAddress(9999));  //port number is 9999
    }

    public static void main(String[] args) throws Exception {
        run();
    }
}