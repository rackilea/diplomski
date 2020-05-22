@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

@Override
public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/login").setViewName("login");
    registry.addViewController("/welcome").setViewName("welcome");
    registry.addViewController("/about").setViewName("about");
    registry.addViewController("/contact").setViewName("contact");
}