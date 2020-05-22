@ServerEndpoint(value = "/ws/{wsQualifier}",
                encoders = CommandEncoder.class,
                decoders = CommandDecoder.class) {

  @OnMessage
  public void onMessage(Command message,
                          Session session,
                          @PathParam("wsQualifier") int ws) {
    switch(ws) {
      case 1:dosomething(message,session);break;
      case 2:doAnotherThing(message,session);break; 
    }
  }
}