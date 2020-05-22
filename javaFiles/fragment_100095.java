@Configuration
public class ApplicationConfiguration {
    @Value("${com.domain.app.hadoop.fs-uri}")
    private URI hdfsUri;

    @Value("${com.domain.app.hadoop.user}")
    private String user;

    @Value("${com.domain.app.hadoop.hive.jdbc-uri}")
    private String hiveUri;

    @Autowired
    private org.apache.hadoop.conf.Configuration hadoopConfiguration;

    @Bean
    public org.apache.hadoop.conf.Configuration hadoopConfiguration() {
        return new org.apache.hadoop.conf.Configuration();
    }

    @Bean
    public HdfsResourceLoader hdfsResourceLoader() {
        return new HdfsResourceLoader(hadoopConfiguration, hdfsUri, user);
    }

    @Bean
    public HiveTemplate hiveTemplate() {
        return new HiveTemplate(() -> {
            final SimpleDriverDataSource dataSource = new SimpleDriverDataSource(new HiveDriver(), hiveUri);
            return new HiveClient(dataSource);
        });
    }
}