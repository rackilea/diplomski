public class ICAPClientChannelPipeline implements ICAPClientPipeline {

        ICAPClientHandler icapClientHandler;
        ChannelPipeline pipeline;

        public ICAPClientChannelPipeline(){
            icapClientHandler = new ICAPClientHandler();
        pipeline = pipeline(); 
            pipeline.addLast("idleStateHandler", new IdleStateHandler(new HashedWheelTimer(10, TimeUnit.MILLISECONDS), 5, 5, 5));
            pipeline.addLast("idleStateAwareHandler", new IdleStateAwareHandler());
            pipeline.addLast("encoder",new IcapRequestEncoder());
            pipeline.addLast("chunkSeparator",new IcapChunkSeparator(1024*4));
            pipeline.addLast("decoder",new IcapResponseDecoder());
            pipeline.addLast("chunkAggregator",new IcapChunkAggregator(1024*4));
            pipeline.addLast("handler", icapClientHandler);            
        }

        @Override
    public ChannelPipeline getPipeline() throws Exception {
            return pipeline;
    }                     
}