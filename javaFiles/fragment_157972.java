ChannelPipeline pipeline = Channels.pipeline();
 pipeline.addLast("idler", idleStateHandler);
 pipeline.addLast("decoder", new HttpRequestDecoder());
 pipeline.addLast("encoder", new HttpResponseEncoder());
 pipeline.addLast("timer-outer", new TimeOutHandler());
 pipeline.addLast("handler", new HTTPRequestHandler());