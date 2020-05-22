public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class);
        container.addListener(new ContextLoaderListener(context));

        // Message Dispatcher Servlet (SOAP)
        MessageDispatcherServlet messageDispatcherServlet = new MessageDispatcherServlet();
        messageDispatcherServlet.setApplicationContext(context);
        messageDispatcherServlet.setTransformWsdlLocations(true);
        ServletRegistration.Dynamic messageDispatcher = container.addServlet("messageDispatcher", messageDispatcherServlet);
        messageDispatcher.setLoadOnStartup(1);
        messageDispatcher.addMapping("/ws/*");
    }
}