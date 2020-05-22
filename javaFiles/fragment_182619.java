@SpringBootApplication
public class So48223952Application {

    public static void main(String[] args) {
        SpringApplication.run(So48223952Application.class, args).close();
    }

    @Bean
    public ApplicationRunner runner(JmsTemplate template) {
        return args -> {
            template.convertAndSend("foo", "sendingFoo", m -> {
                m.setStringProperty("myHeader", "foo");
                return m;
            });
            template.convertAndSend("foo", "sendingBar", m -> {
                m.setStringProperty("myHeader", "bar");
                return m;
            });
            Thread.sleep(10_000);
        };
    }

    @Bean
    public IntegrationFlow flow(ConnectionFactory connectionFactory) {
        return IntegrationFlows.from(Jms.messageDrivenChannelAdapter(connectionFactory)
                        .destination("foo"))
                .channel(MessageChannels.publishSubscribe("pubsub"))
                .route("headers['myHeader']",
                        m -> m.channelMapping("foo", "fooChannel")
                              .channelMapping("bar", "barChannel"))
                .get();
    }

    @Bean
    public IntegrationFlow toMongo() {
        return IntegrationFlows.from("pubsub")
                .<String, String>transform(p -> "Sending to db " + p)
                .handle(System.out::println) // store in DB here
                .get();
    }

    @Bean
    public IntegrationFlow foo() {
        return IntegrationFlows.from("fooChannel")
                .<String, String>transform(p -> "on fooChannel " + p)
                .handle(System.out::println)
                .get();
    }

    @Bean
    public IntegrationFlow bar() {
        return IntegrationFlows.from("barChannel")
                .<String, String>transform(p -> "on barChannel " + p)
                .handle(System.out::println)
                .get();
    }

}