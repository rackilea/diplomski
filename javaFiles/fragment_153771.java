client = vertx.createHttpClient(new HttpClientOptions()
  .setDefaultHost("ws.cex.io")
  .setDefaultPort(443)
  .setSsl(true));

client.websocket("/ws", ws -> {
  // Work with the websocket
});