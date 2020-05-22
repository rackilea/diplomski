@PropertySource("classpath:AwsCredentials.properties")
public class AWSConfiguration {

    @Autowired
    private Environment env;

    @Bean
    public AwsCredentials credentials() {
        String secretKey = env.getRequiredProperty("name of property");
        String accessKey = env.getRequiredProperty("name of property");
        return new BasicCredentials(accessKey, secretKey);
    }

}