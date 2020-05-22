@Override
public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
    String messageToString = message.getPayload().toString();
    if (messageToString.startsWith("token=")) {
        tokenToSessionMapping.put(messageToString.substring("token=".length()));
    }
    // Other handling message code...
}