public Mono<Void> handle(final WebSocketSession session) {
    final String sessionId = session.getId();
    if(sessions.add(sessionId)) {  // add session id to set to keep a count of active sessions
        LOG.info("Starting WebSocket Session [{}]", sessionId);
        // Send the session id back to the client
        WebSocketMessage msg = session.textMessage(String.format("{\"session\":\"%s\"}", sessionId));
        // Register the outbound flux as the source of outbound messages
        final Flux<WebSocketMessage> outFlux = Flux.concat(Flux.just(msg), newMetricFlux.map(metric -> {
            LOG.info("Sending message to client [{}]: {}", sessionId, metric);
            return session.textMessage(metric);             
        }));
        // Subscribe to the inbound message flux
        session.receive().doFinally(sig -> {
            LOG.info("Terminating WebSocket Session (client side) sig: [{}], [{}]", sig.name(), sessionId);
            session.close();
            sessions.remove(sessionId);  // remove the stored session id
        }).subscribe(inMsg -> {
            LOG.info("Received inbound message from client [{}]: {}", sessionId, inMsg.getPayloadAsText());
        });
        return session.send(outFlux);
    }
    return Mono.empty();
}