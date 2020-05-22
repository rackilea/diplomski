@Test
public void testNingWebSockets() throws Exception {
    logger.debug("START testNingWebSockets()");

    String wsUrl = "ws://localhost:8081/websocket";
    String wssUrl = "wss://localhost:8444/websocket";
    AsyncHttpClient client = new AsyncHttpClient();
    WebSocketUpgradeHandler handler = new WebSocketUpgradeHandler.Builder().addWebSocketListener(new ClientWebSocket()).build();
    WebSocket websocket = client.prepareGet(wssUrl).execute(handler).get();
    Assert.assertNotNull("No connection!", websocket);
    logger.debug("Connection made: " + websocket.isOpen());
    websocket.sendMessage("TestMessage".getBytes());
    Thread.sleep(1000);
    websocket.close();
    logger.debug("END testNingWebSockets()");
}