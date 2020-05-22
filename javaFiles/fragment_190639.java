@Configuration
@EnableAsync
@ComponentScan
public class AsyncConfiguration implements AsyncConfigurer {

    @Autowired
    MyExceptionHandler rccAsyncExceptionHandler;

    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return rccAsyncExceptionHandler;
    }
}