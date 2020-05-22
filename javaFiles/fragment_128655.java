public class AppConfig extends WebMvcConfigurerAdapter {

        @Override
        public void addViewControllers(ViewControllerRegistry registry) {
            registry.addViewController("/canary").setViewName("/canary/canary.html");
        }
}