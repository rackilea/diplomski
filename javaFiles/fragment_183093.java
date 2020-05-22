@Configuration
@EnableWebSocketMessageBroker
@EnableReactor
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @autowired
    Environment reactorEnv;

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry configurer) {
        configurer.setApplicationDestinationPrefixes("/app");
        configurer.enableSimpleBroker("/topic", "/queue");
    }

    @Bean
    public AbstractSubscribableChannel clientInboundChannel() {
        ExecutorSubscribableChannel channel = new ExecutorSubscribableChannel(new RingBufferAsyncTaskExecutor(this.reactorEnv));
        ChannelRegistration reg = getClientOutboundChannelRegistration();
        channel.setInterceptors(reg.getInterceptors());
        return channel;
    }

}