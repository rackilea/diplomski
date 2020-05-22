ChannelPipeline pipeline = ...;

 // Decoders
 pipeline.addLast("frameDecoder", new LineBasedFrameDecoder(80));
 pipeline.addLast("stringDecoder", new StringDecoder(CharsetUtil.UTF_8));

 // Encoder
 pipeline.addLast("stringEncoder", new StringEncoder(CharsetUtil.UTF_8));