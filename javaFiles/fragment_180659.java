@EnableWebMvc
public class WebConfig extends WebMvcConfigurerAdapter
{
    /**
     * Among your other methods in this class, make sure you register
     * your Interceptor.
     */
    @Override
    public void addInterceptors(final InterceptorRegistry registry)
    {
        // Register firewall interceptor for all URLs in webapp.
        registry.addInterceptor(new FirewallInterceptor()).addPathPatterns("/**");
        return;
    }
}