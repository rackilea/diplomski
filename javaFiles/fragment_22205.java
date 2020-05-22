@Configuration
public class SpringWebConfig implements WebMvcConfigurer {

    //Make sure the HandlerInterceptor implementation in this JAR is a bean (e.g mark it as @Component)
    @Autowired
    private List<HandlerInterceptor> interceptors;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        for(HandlerInterceptor interceptor : interceptors){
            registry.addInterceptor(interceptor).addPathPatterns("/api/endpoint/**");
        }
    }
}