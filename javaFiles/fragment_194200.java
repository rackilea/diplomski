@Configuration
public class WorkaroundConfig extends WebMvcConfigurerAdapter {

    @Autowired
    @Qualifier("tokenRelayRequestInterceptor")
    HandlerInterceptor handlerInterceptor;

    @Override
    public void addInterceptors (InterceptorRegistry registry) {
        registry.addInterceptor(handlerInterceptor);
    }

}