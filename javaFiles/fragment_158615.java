private class MyWebSocketHandler implements StompSessionHandler {
    @Override
    public void afterConnected(StompSession stompSession, StompHeaders stompHeaders) {

    }

    @Override
    public void handleException(StompSession stompSession, StompCommand stompCommand, StompHeaders stompHeaders, byte[] bytes, Throwable throwable) {
    }

    @Override
    public void handleTransportError(StompSession stompSession, Throwable throwable) {
        if (throwable instanceof ConnectionLostException) {
            // if connection lost, call this
        }
    }

    @Override
    public Type getPayloadType(StompHeaders stompHeaders) {
        return null;
    }

    @Override
    public void handleFrame(StompHeaders stompHeaders, Object o) {
    }
}