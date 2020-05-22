@Bean
public IntegrationFlow flow() {
    ExecutorService exec = Executors.newFixedThreadPool(10);
    return IntegrationFlows.from(Files.inboundAdapter(new File("/tmp/foo")).filter(
                new FileSystemPersistentAcceptOnceFileListFilter(new SimpleMetadataStore(), "foo")),
                    e -> e.poller(Pollers.fixedDelay(5, TimeUnit.SECONDS)
                            .maxMessagesPerPoll(10)))
            .channel(MessageChannels.executor(exec))
            .<File>handle((p, h) -> {
                try {
                    p.delete();
                    logger.info(p.toString());
                    Thread.sleep(10_000);
                }
                catch (InterruptedException e1) {
                    Thread.currentThread().interrupt();
                }
                return null;
            })
            .get();
}