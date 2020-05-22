@Bean(name="rulesThreadExecutor")
public Executor asyncExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(2);
    executor.setMaxPoolSize(2);
    executor.setQueueCapacity(500);
    executor.setThreadNamePrefix("Rules-");
    executor.initialize();
    return executor;
}

@Async("rulesThreadExecutor")
public CompletableFuture<Void> anotherMethod(int i) {
    LOGGER.info("hello world");
    return CompletableFuture.completedFuture(null);
}