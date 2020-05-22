@SpringBootApplication
@RestController
public class SpringIntegrationSseDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationSseDemoApplication.class, args);
    }

    @Bean
    public Publisher<Message<String>> httpReactiveSource() {
        return IntegrationFlows.
                from(Http.inboundChannelAdapter("/message/{id}")
                        .requestMapping(r -> r
                                .methods(HttpMethod.POST)
                        )
                        .payloadExpression("#pathVariables.id")
                )
                .channel(MessageChannels.queue())
                .toReactivePublisher();
    }

    @GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> eventMessages() {
        return Flux.from(httpReactiveSource())
                .map(Message::getPayload);
    }

}