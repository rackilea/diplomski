@Configuration
public class Configuration {

    @Bean
    public LevelApprovalService getLevelApprovalService() {
        return LevelApprovalServiceImpl.getInstance();
    }

}