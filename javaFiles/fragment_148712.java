@SpringBootApplication
public class So52526134Application {

    public static void main(String[] args) {
        SpringApplication.run(So52526134Application.class, args);
    }

    @Bean
    public IntegrationFlow mainFlow() {
        return IntegrationFlows.from(() -> "foo", e -> e.poller(Pollers.fixedDelay(5000)))
                .enrichHeaders(h -> h.header(MessageHeaders.ERROR_CHANNEL, "myErrors.input"))
                .channel(MessageChannels.executor(executor()))
                .handle((p, h) -> {
                    throw new RuntimeException("foo");
                })
                .get();
    }

    @Bean
    public IntegrationFlow myErrors() {
        return f -> f.handle((p, h) -> {
            System.out.println("in my error flow");
            return p;
        })
        .handle(System.out::println);
    }

    @Bean
    public TaskExecutor executor() {
        return new ThreadPoolTaskExecutor();
    }

}