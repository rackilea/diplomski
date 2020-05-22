@Configuration
public class Restbucks extends SpringBootServletInitializer {

    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Restbucks.class, ComponentConfiguration.class);
    }

    @Bean
    public MeteorServlet dispatcherServlet() {
        return new MeteorServlet();
    }

    @Bean
    public ServletRegistrationBean dispatcherServletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(dispatcherServlet());
        Map<String,String> params = new HashMap<String,String>();
        params.put("org.atmosphere.servlet","org.springframework.web.servlet.DispatcherServlet");
        params.put("contextClass","org.springframework.web.context.support.AnnotationConfigWebApplicationContext");
        params.put("contextConfigLocation","net.org.selector.animals.config.ComponentConfiguration");
        registration.setInitParameters(params);
        return registration;
    }

}