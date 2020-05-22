@Configuration
@EnableAsync
@EnableScheduling
public class SpringBootConfiguration {

    @Bean
    public Executor getTaskExecutor() {
        return Executors.newScheduledThreadPool(10);
    }
}