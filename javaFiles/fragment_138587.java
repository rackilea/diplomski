vertx.createNetServer().connectHandler(sock -> {

  RecordParser parser = RecordParser.newDelimited("\n", sock);

  FlowableHelper.toFlowable(parser)
    .map(EchoRequestMessage::fromBuffer)
    .map(echoRequestMessage -> {
      return new EchoResponseMessage(echoRequestMessage.getMessage());
    })
    .subscribe(echoResponseMessage -> sock.write(echoResponseMessage.toBuffer()).write("\n"), throwable -> {
      throwable.printStackTrace();
      sock.close();
    }, sock::close);

}).listen(1234);