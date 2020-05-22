@Configuration
@EnableSpringDataWebSupport
@EnableWebMvc
class MvcConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {
        registry.addInterceptor(getMyInterceptor());
    }

    @Bean
    public MyInterceptor getMyInterceptor() {
        return new MyInterceptor();
    }
}