@Configuration
@ImportResource(
        value = {
                "classpath:org/springframework/batch/admin/web/resources/servlet-config.xml",
                "classpath:org/springframework/batch/admin/web/resources/webapp-config.xml"
        }
    )
public class BatchConfiguration {
    @Bean
    public JobBuilderFactory jobBuilderFactory(JobRepository jobRepository) {
        return new JobBuilderFactory(jobRepository);
    }

    @Bean
    public StepBuilderFactory stepBuilderFactory(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilderFactory(jobRepository, transactionManager);
    }
}