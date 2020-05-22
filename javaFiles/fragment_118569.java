@Bean(name= "myExecutor")
public Executor getCustomAsyncExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(10);
    executor.setMaxPoolSize(100);
    executor.setQueueCapacity(100);
    executor.initialize();
    return executor;
}