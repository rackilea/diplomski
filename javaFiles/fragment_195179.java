@SpringBootApplication
public class So47357940Application {

    public static void main(String[] args) {
        SpringApplication.run(So47357940Application.class, args);
    }

    @Bean
    public ApplicationRunner runner(AmqpAdmin admin) {
        return args -> admin.deleteQueue("so47357940");
    }

    @RabbitListener(queues = "so47357940")
    public void listen(String in) {
        System.out.println(in);
    }

    private final Map<SimpleMessageListenerContainer, AtomicBoolean> shuttingDown = new ConcurrentHashMap<>();

    @Bean
    public ApplicationListener<ListenerContainerConsumerFailedEvent> failures(AmqpAdmin admin,
            RabbitTemplate template) {
        return event -> {
            if (event.isFatal()) {
                SimpleMessageListenerContainer container = (SimpleMessageListenerContainer) event.getSource();
                AtomicBoolean sd = this.shuttingDown.computeIfAbsent(container, v -> new AtomicBoolean());
                if (sd.compareAndSet(false, true)) {
                    System.out.println("RECREATING");
                    String[] qn = container.getQueueNames();
                    String q = qn[0];
                    admin.declareQueue(new Queue(q));
                    // better to use a shared exec
                    ExecutorService exec = Executors.newSingleThreadExecutor();
                    exec.execute(() -> {
                        while (container.isRunning()) {
                            // should probably give up at some point
                            try {
                                Thread.sleep(100);
                            }
                            catch (InterruptedException e) {
                                Thread.currentThread().interrupt();
                            }
                        }
                        container.start();
                        template.convertAndSend("so47357940", "foo");
                        this.shuttingDown.remove(container);
                    });
                }
                else {
                    System.out.println("RECREATING_NOT");
                }
            }
            else {
                System.out.println("NON_FATAL");
            }
        };
    }

}