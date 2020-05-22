@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean registerFilter(BasicFilter filter) { // Inject it
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(filter); // Use it
        registration.addUrlPatterns("/secure/*");
        return registration;
   }
}