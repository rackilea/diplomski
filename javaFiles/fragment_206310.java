@Configuration
@Profile("Test")
public class TestConfig {

    @Mock
    AmazonS3Client client;

    public TestConfig(){
        MockitoAnnotations.initMocks(this);
    }

    @Bean
    public AmazonS3Client amazonS3Client(){
        return client;
    }
}