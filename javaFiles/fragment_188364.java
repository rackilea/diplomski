@SpringBootApplication
public class So49401150Application {

    public static void main(String[] args) {
        SpringApplication.run(So49401150Application.class, args);
    }

    @Bean
    ApplicationRunner runner(ConnectionFactory cf, RabbitTemplate template,
            RabbitListenerEndpointRegistry registry) {
        return args -> {
            cf.createConnection().close(); // Admin does declarations here
            template.convertAndSend("myexchange", "", "foo");
            Thread.sleep(30_000);
            registry.start();
        };
    }

    @RabbitListener(autoStartup="false",
            bindings = @QueueBinding(value = @Queue,
            exchange = @Exchange(name="myexchange",
                                 type=ExchangeTypes.FANOUT)))
    public void processMessage(String message) {
        System.out.println(message);
    }

}