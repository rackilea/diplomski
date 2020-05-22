@Bean
public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
    ThreadPoolTaskScheduler threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
    threadPoolTaskScheduler.setPoolSize(THREAD_COUNT);// use 1 for this use case
    return threadPoolTaskScheduler;
}