@Bean
    public IntegrationFlow dedicatedPollingThreadFlow() {
        return IntegrationFlows.from(MessageChannels.queue("myQueueChannel"))
                .bridge(e -> e
                        .poller(Pollers.fixedDelay(0).receiveTimeout(-1))
                        .id("dedicatedPollingConsumer"))
                .channel(c -> c.queue("results"))
                .get();
    }

    @Bean
    public TaskScheduler dedicatedTaskScheduler() {
        return new ThreadPoolTaskScheduler();
    }

    @Bean
    @DependsOn("dedicatedPollingThreadFlow")
    public String dedicatedPollingConsumerConfigurer(
            @Qualifier("dedicatedPollingConsumer") PollingConsumer dedicatedPollingConsumer) {
        dedicatedPollingConsumer.setTaskScheduler(dedicatedTaskScheduler());
        return "";
    }