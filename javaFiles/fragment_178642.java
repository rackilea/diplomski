@Bean
public ServletRegistrationBean dispatcherServlet() {
    ServletRegistrationBean registration = new ServletRegistrationBean(
            new DispatcherServlet(), "/");
    registration.setAsyncSupported(true);
    return registration;
}