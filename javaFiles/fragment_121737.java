@SpringBootApplication
public class So56025184Application {

    public static void main(String[] args) {
        SpringApplication.run(So56025184Application.class, args);
    }

    @Bean
    public ApplicationRunner runner(RabbitTemplate template) {
        return args -> {
            Scanner scanner = new Scanner(System.in);
            String toSend = scanner.nextLine();
            while (!"quit".equals(toSend)) {
                System.out.println(template.convertSendAndReceive("q1", toSend));
                toSend = scanner.nextLine();
            }
            scanner.close();
        };
    }

    @RabbitListener(queues = "q1")
    public String listen(String in) {
        return in.toUpperCase();
    }

    @Bean
    public Queue queue() { // RabbitAdmin will add this to the broker
        return new Queue("q1");
    }

}