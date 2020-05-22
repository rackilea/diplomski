@SpringBootApplication
@EnableBinding(Source.class)
public class So43614477Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(So43614477Application.class, args).close();
    }

    @Autowired
    private MessageChannel output;

    @Autowired
    private AmqpAdmin admin;

    @Value("${spring.cloud.stream.bindings.output.producer.partition-count}")
    private int partitionCount;

    @Value("${spring.cloud.stream.bindings.output.destination}")
    private String destination;

    @Override
    public void run(String... args) throws Exception {
        for (int i = 0; i < this.partitionCount; i++) {
            String partition = this.destination + "-" + i;
            TopicExchange exchange = new TopicExchange(partition);
            this.admin.declareExchange(exchange);
            Binding binding = BindingBuilder.bind(exchange).to(new TopicExchange(this.destination))
                    .with(partition);
            this.admin.declareBinding(binding);
        }

        output.send(MessageBuilder.withPayload("fiz").setHeader("whichPart", 0).build());
        output.send(MessageBuilder.withPayload("buz").setHeader("whichPart", 1).build());
    }

}