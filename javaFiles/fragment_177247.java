void sendEvent(SseEmitter sseEmitter, String toolId, String message) {
    SseEmitter.SseEventBuilder sseEventBuilder = SseEmitter.event()
            .data(message)
            .name(toolId);

    try {
      sseEmitter.send(sseEventBuilder );
      log.debug("Sending SSEvent");
    } catch (ClientAbortException e) {
      log.error("Stream connection is not longer established. Aborting.", e);
    } catch (IOException e) {
      log.error("Server sent event emitter failed", e);
    }

  }