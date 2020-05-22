AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
context.register(ApplicationConfig.class);

servletContext.addListener(new ContextLoaderListener(context));

ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
servletRegistration.setLoadOnStartup(1);
servletRegistration.addMapping("*.htmlx");