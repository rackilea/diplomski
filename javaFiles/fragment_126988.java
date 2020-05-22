public class WebAppInitializer implements WebApplicationInitializer {

    ...

    private WebApplicationContext createRootContext(ServletContext servletContext) {
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();

        rootContext.register(CoreConfig.class, SecurityConfig.class, OAuth2ServerConfig.OAuth2Config.class, MethodSecurityConfig.class);
        rootContext.refresh();

        servletContext.addListener(new ContextLoaderListener(rootContext));
        servletContext.setInitParameter("defaultHtmlEscape", "true");

        return rootContext;
    }

    ...
}