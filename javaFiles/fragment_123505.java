SentenceReader reader = new NettySentenceReader();
bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
    private static final StringDecoder DECODER = new StringDecoder();
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));
        pipeline.addLast(DECODER);
        pipeline.addLast(new SentenceReaderHandler(reader)); 
    }
});