@Configuration
public class ExecutorConfig extends AsyncConfigurerSupport {

    @Override
    @Bean( "asyncTaskExecutor")
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setThreadNamePrefix("contextAwareExecutor-");
        executor.initialize();
        return new ContextAwareExecutorDecorator(executor);
    }

    @Override
    @Bean
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new CustomAsyncExceptionHandler();
    }
}