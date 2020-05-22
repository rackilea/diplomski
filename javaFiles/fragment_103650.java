@Configuration
public class Test {

    @Bean
    public PropertyPlaceholderConfigurer getPropertyPlaceholderConfigurer()
            throws IOException {
        PropertyPlaceholderConfigurer ppc = new PropertyPlaceholderConfigurer();
        ppc.setLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/**/abc.properties"));
        return ppc;
    }