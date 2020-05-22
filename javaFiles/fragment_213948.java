@SpringBootApplication
public class So53521593Application {

    private static final Logger logger = LoggerFactory.getLogger(So53521593Application.class);

    public static void main(String[] args) {
        SpringApplication.run(So53521593Application.class, args);
    }

    @Bean
    public IntegrationFlow flow() {
        ExecutorService exec = Executors.newFixedThreadPool(10);
        return IntegrationFlows.from(() -> "foo", e -> e
                    .poller(Pollers.fixedDelay(5, TimeUnit.SECONDS)
                            .maxMessagesPerPoll(10)))
                .channel(MessageChannels.executor(exec))
                .<String>handle((p, h) -> {
                    try {
                        logger.info(p);
                        Thread.sleep(10_000);
                    }
                    catch (InterruptedException e1) {
                        Thread.currentThread().interrupt();
                    }
                    return null;
                })
                .get();
    }
}