@Override
public void onStartup(ServletContext container) throws ServletException {
    AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
    // Initialize web mvc
    appContext.setDisplayName("APP");
    appContext.register(WebConfig.class);
    appContext.register(SecurityConfig.class);

    // Rest omitted (listeners, dispatcher servlet, etc.)
}