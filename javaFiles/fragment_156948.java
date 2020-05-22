public abstract class AbstractApiModuleAutoConfiguration<T> {

    @Autowired
    protected ApplicationContext applicationContext;

    @Autowired
    protected ServerProperties server;

    @Autowired(required = false)
    protected MultipartConfigElement multipartConfig;

    @Value("${project.rest.base-api-path}")
    protected String baseApiPath;

    protected DispatcherServlet createApiModuleDispatcherServlet() {
        AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
        webContext.setParent(applicationContext);
        webContext.register(getApiModuleConfigurationClass());
        return new DispatcherServlet(webContext);
    }

    protected ServletRegistrationBean createApiModuleDispatcherServletRegistration(DispatcherServlet apiModuleDispatcherServlet) {
        ServletRegistrationBean registration = new ServletRegistrationBean(
                apiModuleDispatcherServlet,
                this.server.getServletMapping() + baseApiPath + "/" + getApiModulePath() + "/*");

        registration.setName(getApiModuleDispatcherServletBeanName());
        if (this.multipartConfig != null) {
            registration.setMultipartConfig(this.multipartConfig);
        }
        return registration;
    }

    protected abstract String getApiModuleDispatcherServletBeanName();

    protected abstract String getApiModulePath();

    protected abstract Class<T> getApiModuleConfigurationClass();

}