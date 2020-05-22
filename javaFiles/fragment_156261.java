synchronized (sseEmitter) {
    sseEmitter.forEach((SseEmitter emitter) -> {
        try {
            emitter.send(state, MediaType.APPLICATION_JSON);
        } catch (IOException e) {
            emitter.complete();
            sseEmitter.remove(emitter);
        }
    });
}