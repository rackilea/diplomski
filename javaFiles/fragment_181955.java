@Bean
public ServletRegistrationBean dispatcherServletRegistration() {
    ServletRegistrationBean registration = new ServletRegistrationBean(
            dispatcherServlet(), "/api/*");
    dispatcherServlet().setThrowExceptionIfNoHandlerFound(true);
    registration.setName(DispatcherServletAutoConfiguration.DEFAULT_DISPATCHER_SERVLET_REGISTRATION_BEAN_NAME);
    return registration;
}