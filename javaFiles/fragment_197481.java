@Configuration
public class PropertiesConfiguration {
    @Bean
    public static PropertyPlaceholderConfigurer propertyPlaceholderConfigurer(
            @Value("#{servletContext.contextPath}") String contextPath) throws MalformedURLException
    {
        final PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        configurer.setLocation(new UrlResource("file:" + System.getProperty("user.home") + "/" + contextPath + ".properties"));
        return configurer;
    }
}