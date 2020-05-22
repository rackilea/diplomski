@WebListener
public class SpringContextLoader extends ContextLoaderListener {

    @Override
    protected WebApplicationContext createWebApplicationContext(final ServletContext sc) {
        AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
        applicationContext.register(SpringConfiguration.class);

        sc.addFilter("springSecurityFilterChain", new DelegatingFilterProxy("springSecurityFilterChain")).addMappingForUrlPatterns(null, false, "/*");

        Dynamic dynamic = sc.addServlet("dispatcher", new DispatcherServlet(applicationContext));  
        dynamic.addMapping("/");  
        dynamic.setLoadOnStartup(1); 

        return applicationContext;
    }
}