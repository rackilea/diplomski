@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer
{
    @Override
    public void configureMessageBroker(final MessageBrokerRegistry config)
    {
        config.enableSimpleBroker("/topic");
    }

    @Override
    public void registerStompEndpoints(final StompEndpointRegistry registry)
    {
        registry.addEndpoint("/updates")
            .setAllowedOrigins("*")
            .withSockJS();
    }
}