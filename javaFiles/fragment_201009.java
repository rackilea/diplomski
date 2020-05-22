@Configuration
@EnableAsync(proxyTargetClass=true) //detects @Async annotation
public class AsyncConfig implements AsyncConfigurer {

 public Executor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10); // create 10 Threads at the time of initialization
        executor.setQueueCapacity(10); // queue capacity
        executor.setMaxPoolSize(25); // if queue is full, then it will create new thread and go till 25
        executor.setThreadNamePrefix("DEMO-");
        executor.initialize();//Set up the ExecutorService.
        return executor;
    }

    @Override
    public Executor getAsyncExecutor() {
        return threadPoolTaskExecutor();
    }

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new YOUR_CUSTOM_EXCEPTION_HANDLER();
    }

}