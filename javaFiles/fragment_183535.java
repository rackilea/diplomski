@Configuration
public class AwsConfig {

    @Value("${upplication.aws.accessKey}")
    private String accessKey;

    @Value("${upplication.aws.secretKey}")
    private String secretKey;

    @Bean
    public FileSystem s3FileSystem() throws IOException {
        Map<String, String> env = new HashMap<>();
        env.put(com.upplication.s3fs.AmazonS3Factory.ACCESS_KEY, accessKey);
        env.put(com.upplication.s3fs.AmazonS3Factory.SECRET_KEY, secretKey);

        return FileSystems.newFileSystem(URI.create("s3:///"), env, Thread.currentThread().getContextClassLoader());
    }
}