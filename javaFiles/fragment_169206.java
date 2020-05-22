public class AppInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext container) {

        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(ServiceConfiguration.class);

        container.addListener(new ContextLoaderListener(context));

        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new CXFServlet());
        dispatcher.setLoadOnStartup(1);

        dispatcher.addMapping("/services/*");
    }
}