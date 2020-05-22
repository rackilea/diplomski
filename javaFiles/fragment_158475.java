@Configuration
public class MyConfiguration {

    public static final String DEFAULT_PROPERTY_VALUE = "long string...";

    @Autowired
    private Environment env;

    @Bean("midPriceDDSEndpoint")
    public DistributedDataSpace<Long, MidPriceStrategy> midPriceDDSEndpoint() {
        String myPropertyValue = env.getProperty("foo.bar.my-property", DEFAULT_PROPERTY_VALUE);
    }
}