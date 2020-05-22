class MyWebSocketAdapter implements WebSocketAdapter {
   // Store the responseFuture as a member of the adapter. 
   private CompletableFuture<String> responseFuture;

   public String sendCommand(String command) {
       // CompletableFutures can only be "used" once, so create a new object
       responseFuture = new CompletableFuture<String>();
       webSocket.sendText(command);
       // Keep in mind potential errors and a timeout value to this call
       return responseFuture.get();
   }

   @Override
   public void onTextMessage(WebSocket websocket, String text) throws Exception {
      super.onTextMessage(websocket, text);
      // Do what you want to do with the text and then complete the future
      responseFuture.complete(text);
   }
}