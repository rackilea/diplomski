@Component
public class DiConfig {

    @Bean
    public SecurityUtil securityUtil(
            @Value("${security-util.key}") String securityUtilKey,
            @Value("${security-util.algorithm}") String securityUtilAlgorithm) {
        return new SecurityUtil(securityUtilKey, securityUtilAlgorithm);
    }
}