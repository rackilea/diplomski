public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/ws")
        .setAllowedOrigins("*").withSockJS();
}

var socket = new SockJS('/hello');