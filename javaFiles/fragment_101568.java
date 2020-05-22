ChannelPipeline next = Channels.pipeline();
next.addLast("frameDecoder", new ProtobufVarint32FrameDecoder());
next.addLast("protobufDecoder", new ProtobufDecoder(TestMessage.getDefaultInstance()));
next.addLast("frameEncoder", new ProtobufVarint32LengthFieldPrepender());
next.addLast("protobufEncoder", new ProtobufEncoder());

next.addLast("protobufHandler", new ProtobufHandler()); //add this.