@Configuration
public class JobFrameworkConfig {  
    @Bean
    public static StepScope scope() {
        return new StepScope();
    }
    // jobRegistry, transactionManager etc...
}