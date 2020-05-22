@Configuration
public class AppInitializer
{
    @Bean
    public FilterRegistrationBean<AccessTokenAlterFilter> sessionTimeoutFilter()
    {
        FilterRegistrationBean<AccessTokenAlterFilter> registrationBean = new FilterRegistrationBean<>();
        AccessTokenAlterFilter filter = new AccessTokenAlterFilter();

        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns("/oauth/token");
        registrationBean.setOrder(1); // set precedence
        return registrationBean;
    }
}