public Executor proxyTaskExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(Runtime.getRuntime().availableProcessors() * 2 - 1);
    executor.setMaxPoolSize(100);
    executor.setQueueCapacity(100); 
    executor.setDaemon(true);
    return executor;
}