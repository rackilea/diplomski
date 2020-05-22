@ClientEndpoint(configurator = MyClientConfigurator.class)
public static class MyClientEndpoint {
    public static final CountDownLatch messageLatch = new CountDownLatch(1);
    public static volatile String receivedMessage;

    @OnOpen
    public void onOpen(Session session) throws IOException {
        session.getBasicRemote().sendText(SENT_MESSAGE);
    }

    @OnMessage
    public void onMessage(String message) {
        receivedMessage = message;
        messageLatch.countDown();
    }
}