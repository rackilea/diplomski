@Configuration
@PropertySource(
        value={"classpath:log4jdbc.log4j2.properties"},
        ignoreResourceNotFound = true)
public class DispatcherServletConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("redirect:/member/login.do");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new BusinessInterceptor());
    }
}