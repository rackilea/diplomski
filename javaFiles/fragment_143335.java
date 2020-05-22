public void handleMessageToClient(WebSocketSession session, Message<?> message) {
    //...
    SimpAttributes simpAttributes = new SimpAttributes(session.getId(), session.getAttributes());
    SimpAttributesContextHolder.setAttributes(simpAttributes);
    Principal user = getUser(session);
    publishEvent(new SessionConnectedEvent(this, (Message<byte[]>) message, user));
    //...