@Configuration
@EnableAsync
@ComponentScan
public class AsyncConfiguration implements AsyncConfigurer {

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new RccAsyncExceptionHandler();
    }
}