@Override
public void registerStompEndpoints(StompEndpointRegistry registry) {
    registry.addEndpoint("/socket")
            .setAllowedOrigins("*")
            .withSockJS();
}

@Override
public void configureMessageBroker(MessageBrokerRegistry registry) {
    registry.setApplicationDestinationPrefixes("/app")
            .enableSimpleBroker("/chat", "/meeting");
}