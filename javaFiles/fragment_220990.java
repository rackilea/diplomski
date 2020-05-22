@Override
  public void handleTransportError(StompSession session, Throwable exception) {
    logger.warn("Error on websocket session " + session.getSessionId(), exception);

    // todo: schedule a reconnection attempt
  }