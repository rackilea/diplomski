@Override
public void initChannel(SocketChannel ch) throws Exception {
    ChannelPipeline pipeline = ch.pipeline();

    // idle state handler
    pipeline.addLast("idleStateHandler", new IdleStateHandler(60,
            30, 0));
    pipeline.addLast("myHandler", new IdleHandler());

    //add decoder for combining bytes for xml message
    pipeline.addLast("decoder", new XmlFrameDecoder(1048576));  

    // handler for business logic.
    pipeline.addLast("handler", new ServerReceiverHandler()); 
}