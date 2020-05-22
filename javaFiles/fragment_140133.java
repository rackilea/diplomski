@Configuration
public class MyApplicationConfiguration {
    @Bean
    public ThreadPoolTaskScheduler threadPoolTaskScheduler() {
        ThreadPoolTaskScheduler tpts = new ThreadPoolTaskScheduler();
        // maybe configure it a little?
        return tpts;
    }

    @Bean
    public MyService myService() {
        return new MyService();
    }
}

class MyService {
    @Autowired
    private ThreadPoolTaskScheduler tpts;

    public void doSomething() {
        Runnable task = ...
        tpts.scheduleWithFixedDelay(task, 1000);
    }
}