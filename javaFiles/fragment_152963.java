@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/my-login").setViewName("forward:/my-login.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
    }

}