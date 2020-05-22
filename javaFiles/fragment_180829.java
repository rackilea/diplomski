@Order(1)
public MainApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { AppConfig.class, WebSecurity.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebMvc.class };
    }        
}