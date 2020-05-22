@Configuration
public class MultiThreadConfig {

    @Bean
    public TaskExecutor taskExecutor() {
        return new SimpleAsyncTaskExecutor(); // Or use another one of your liking
    }


    @Bean
    public Compressor compressor(ApplicationArguments applicationArguments) {
        return Compressor(applicationArguments);
    }

    @Bean
    public CommandLineRunner schedulingRunner(TaskExecutor executor, Compressor compressor) {
        return new CommandLineRunner() {
            public void run(String[] args) throws Exception {
                executor.execute(compressor);
            }
        };
    }
}