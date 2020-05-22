@Order(1)
public class SpringWebContainerInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        registerContextLoaderListener(servletContext);

        // Set the Jersey used property so it won't load a ContextLoaderListener
        // see bug report https://java.net/jira/browse/JERSEY-2038
        servletContext.setInitParameter("contextConfigLocation", "");
    }

    private void registerContextLoaderListener(ServletContext servletContext) {
        WebApplicationContext webContext;
        webContext = createWebAplicationContext(SpringAnnotationConfig.class);
        servletContext.addListener(new ContextLoaderListener(webContext));
    }

    public WebApplicationContext createWebAplicationContext(Class... configClasses) {
        AnnotationConfigWebApplicationContext context;
        context = new AnnotationConfigWebApplicationContext();
        context.register(configClasses);
        return context;
    }
}