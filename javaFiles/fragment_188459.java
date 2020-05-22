@Bean
public FilterRegistrationBean registerFilter() {
    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(this);
    registration.addUrlPatterns("/secure/*");
    return registration;
}