@Bean
public ServletRegistrationBean jerseyServlet() {
    ServletRegistrationBean bean = new ServletRegistrationBean();
    bean.setServlet(new ServletContainer());
    bean.addInitParameter("com.sun.jersey.config.property.packages",
                          "com.sun.jersey;demo");
    bean.addUrlMappings("/api/*");
    return bean;
}