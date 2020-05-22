@SpringBootApplication
public class So43694619Application implements CommandLineRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(So43694619Application.class, args);
        context.close();
    }

    @Autowired
    RabbitTemplate template;

    @Autowired
    AmqpAdmin admin;

    private final CountDownLatch latch = new CountDownLatch(1);

    @Override
    public void run(String... arg0) throws Exception {
        this.template.convertAndSend("so43694619main", "foo");
        this.latch.await(10, TimeUnit.SECONDS);
        this.admin.deleteExchange("so43694619dlx");
        this.admin.deleteQueue("so43694619main");
        this.admin.deleteQueue("so43694619dlx");
    }


    @Bean
    public Queue main() {
        Map<String, Object> args = new HashMap<>();
        args.put("x-dead-letter-exchange", "so43694619dlx");
        args.put("x-dead-letter-routing-key", "so43694619dlxRK");
        return new Queue("so43694619main", true, false, false, args);
    }

    @Bean
    public Queue dlq() {
        return new Queue("so43694619dlq");
    }

    @Bean
    public DirectExchange dlx() {
        return new DirectExchange("so43694619dlx");
    }

    @Bean
    public Binding dlqBinding() {
        return BindingBuilder.bind(dlq()).to(dlx()).with("so43694619dlxRK");
    }

    @RabbitListener(queues = "so43694619main")
    public void listenMain(String in) {
        throw new AmqpRejectAndDontRequeueException("failed");
    }

    @RabbitListener(queues = "so43694619dlq")
    public void listenDlq(String in) {
        System.out.println("ReceivedFromDLQ: " + in);
        this.latch.countDown();
    }

}