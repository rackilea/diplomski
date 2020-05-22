@Override
public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    Log.info("Socket session closed: {}", status.toString());
    String foundKey = null;
    for (Map.Entry<String, String> entry : tokenToSessionMapping.entrySet()) {
        if (Objects.equals(entry.getValue(), session)) {
            foundKey = entry.getKey();
        }
    }
    if (foundKey != null) {
        tokenToSessionMapping.remove(foundKey);
    }
}