@Configuration
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myInterceptor());
    }

    @Bean
    public MySpringWatcher myInterceptor() {
        return new MySpringWatcher();
    }

    // ... The rest of your configuration ...
}