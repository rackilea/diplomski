@Override
void registerStompEndpoints(StompEndpointRegistry stompEndpointRegistry) {
    stompEndpointRegistry
         .addEndpoint("/stomp") // Set websocket endpoint to connect to
         .setHandshakeHandler(new CustomHandshakeHandler()) // Set custom handshake handler
         .withSockJS() // Add Sock JS support
}