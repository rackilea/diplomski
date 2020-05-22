@Configuration
class SomeConfiguration {

    @Primary
    @Bean
    public TaskExecutor primaryTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        // Customize executor as appropriate
        return executor;
    }

}