@SpringBootApplication
@RestController
public class SpringIntegrationSseDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringIntegrationSseDemoApplication.class, args);
    }

    @Autowired
    private ConnectionFactory connectionFactory;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Bean
    public Publisher<Message<String>> jmsReactiveSource() {
        return IntegrationFlows
                .from(Jms.messageDrivenChannelAdapter(this.connectionFactory)
                        .destination("testQueue"))
                .channel(MessageChannels.queue())
                .log(LoggingHandler.Level.DEBUG)
                .log()
                .toReactivePublisher();
    }

    @GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> getPatientAlerts() {
        return Flux.from(jmsReactiveSource())
                .map(Message::getPayload);
    }

    @GetMapping(value = "/generate")
    public void generateJmsMessage() {
        for (int i = 0; i < 100; i++) {
            this.jmsTemplate.convertAndSend("testQueue", "testMessage #" + (i + 1));
        }
    }

}