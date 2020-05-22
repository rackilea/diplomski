private WebApplicationContext createRootContext(ServletContext servletContext) {
    AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
    //rootContext.register(CoreConfig.class, SecurityConfig.class, OAuth2ServerConfig.class, MethodSecurityConfig.class);
    //rootContext.refresh();

    rootContext.scan(ClassUtils.getPackageName(this.getClass()));

    servletContext.addListener(new ContextLoaderListener(rootContext));
    servletContext.setInitParameter("defaultHtmlEscape", "true");

    return rootContext;
}