@SpringBootApplication
public class So482134501Application {

    private final Map<Integer, IntegrationFlowRegistration> registrations = new HashMap<>();

    @Autowired
    private IntegrationFlowContext flowContext;

    public static void main(String[] args) {
        SpringApplication.run(So482134501Application.class, args);
    }

    @Bean
    public PublishSubscribeChannel channel() {
        return new PublishSubscribeChannel();
    }

    @Bean
    public ApplicationRunner runner(PublishSubscribeChannel channel) {
        return args -> {
            makeANewUdpInbound(1234);
            makeANewUdpInbound(1235);
            makeANewUdpOutbound(1234);
            makeANewUdpOutbound(1235);
            Thread.sleep(5_000);
            channel.send(MessageBuilder.withPayload("foo\n").build());
            this.registrations.values().forEach(r -> {
                r.stop();
                r.destroy();
            });
            this.registrations.clear();
        };
    }

    public void makeANewUdpOutbound(int port) {
        System.out.println("Creating an adapter to send to port " + port);
        IntegrationFlow flow = IntegrationFlows.from(channel())
                .handle(new UnicastSendingMessageHandler("localhost", port))
                .get();
        IntegrationFlowRegistration registration = flowContext.registration(flow).register();
        registrations.put(port, registration);
    }

    public void makeANewUdpInbound(int port) {
        System.out.println("Creating an adapter to receive from port " + port);
        IntegrationFlow flow = IntegrationFlows.from(new UnicastReceivingChannelAdapter(port))
                .<byte[], String>transform(String::new)
                .handle(System.out::println)
                .get();
        IntegrationFlowRegistration registration = flowContext.registration(flow).register();
        registrations.put(port, registration);
    }

}