@SpringBootApplication
@EnableAsync
@EnableScheduling
@ComponentScan
public class WebService extends AsyncConfigurerSupport implements SchedulingConfigurer {
public static void main(String[] args) {
    System.setProperty("http.proxyHost", "localhost");
    System.setProperty("http.proxyPort", "8888");
    System.setProperty("spring.config.name", "web-server");
    SpringApplication.run(WebService.class, args);
}
@Override
public Executor getAsyncExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setCorePoolSize(2);
    executor.setMaxPoolSize(4);
    executor.setQueueCapacity(500);
    executor.setThreadNamePrefix("tester-");
    executor.initialize();
    return executor;
}
@Bean(destroyMethod = "shutdown", name = "scheduledExecutor")
public Executor taskExecutor() {
    return Executors.newScheduledThreadPool(100);
}

@Autowired
@Qualifier(value="scheduledExecutor")
Executor scheduledExecutor;

@Override
public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
    taskRegistrar.setScheduler(scheduledExecutor);
}