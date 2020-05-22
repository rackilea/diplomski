public class MyEndpoint extends Endpoint {

  @Override
  public void onOpen(final Session session, EndpointConfig ec) {
    session.addMessageHandler(new MessageHandler.Whole<String>() {

      @Override
      public void onMessage(String text) {
        try {
          session.getBasicRemote().sendText(text);
        } catch (IOException ex) {
          Logger.getLogger(MyEndpoint.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
  });
}