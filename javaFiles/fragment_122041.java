public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CorsInterceptor(Arrays.asList("'http://myApplication.myDomain.net","http://www.myApplication.myDomain.net")));
    }

    ...

}