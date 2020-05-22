@Configuration
public class AnnotationSecurityConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SecurityAnnotationHandlerInterceptor());
    }

}