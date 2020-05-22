@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(greetingHandler(), "/greeting").withSockJS();
    }

    @Bean
    public WebSocketHandler greetingHandler() {
        return new GreetingHandler();
    }
}