@SpringBootApplication
public class MyApp implements ServletContextAware {

    private BeanThing beanThing = null;

    private ServletContext servletContext; 

    public MyApp() {
        // Lots of stuff goes here.
        // no reference to servletContext, though
        // beanThing gets initialized, and mostly populated.
    }

    @Bean public BeanThing getBeanThing() { return beanThing; }

    @PostConstruct
    public void populateContext() {
        // all references to servletContext go here, including the
        // bit where we call the appropriate setters in beanThing
    }

    public void setServletContext(ServletContext servletContext) {
        this.context = servletContext;
    }


}