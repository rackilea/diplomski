public void handleMessageFromClient(WebSocketSession session, WebSocketMessage<?> webSocketMessage, MessageChannel outputChannel) {
    //...
    SimpAttributesContextHolder.setAttributesFromMessage(message);
    boolean sent = outputChannel.send(message);

    if (sent) {
        if (isConnect) {
            Principal user = headerAccessor.getUser();
            if (user != null && user != session.getPrincipal()) {
                this.stompAuthentications.put(session.getId(), user);
            }
        }
        if (this.eventPublisher != null) {
            if (isConnect) {
                publishEvent(new SessionConnectEvent(this, message, getUser(session)));
            }
    //...