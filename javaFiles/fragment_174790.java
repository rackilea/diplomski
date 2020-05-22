@SpringBootApplication
public class So48213450Application {

    private final Map<Integer, IntegrationFlowRegistration> registrations = new HashMap<>();

    public static void main(String[] args) {
        SpringApplication.run(So48213450Application.class, args);
    }

    @Bean
    public PublishSubscribeChannel channel() {
        return new PublishSubscribeChannel();
    }

    @Bean
    public ApplicationRunner runner(PublishSubscribeChannel channel) {
        return args -> {
            makeANewUdpAdapter(1234);
            makeANewUdpAdapter(1235);
            channel.send(MessageBuilder.withPayload("foo\n").build());
            registrations.values().forEach(r -> {
                r.stop();
                r.destroy();
            });
        };
    }

    @Autowired
    private IntegrationFlowContext flowContext;

    public void makeANewUdpAdapter(int port) {
        System.out.println("Creating an adapter to send to port " + port);
        IntegrationFlow flow = IntegrationFlows.from(channel())
                .handle(Udp.outboundAdapter("localhost", port))
                .get();
        IntegrationFlowRegistration registration = flowContext.registration(flow).register();
        registrations.put(port, registration);
    }

}