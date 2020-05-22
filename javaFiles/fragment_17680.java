@SpringBootApplication
public class So48504265Application {

    public static void main(String[] args) {
        SpringApplication.run(So48504265Application.class, args);
    }

    @Bean
    public BrokerService broker() throws Exception {
        BrokerService broker = new BrokerService();
        broker.addConnector("tcp://localhost:61616);
        return broker;
    }

    @Bean
    public ApplicationRunner runner(JmsTemplate template) {
        return args -> template.convertAndSend("foo", "AMessage");
    }

    @JmsListener(destination = "foo")
    public void listen(String in) {
        System.out.println(in);
    }

}