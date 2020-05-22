@Bean
public FilterRegistrationBean someFilterRegistration() {

    FilterRegistrationBean registration = new FilterRegistrationBean();
    registration.setFilter(someFilter());
    registration.addUrlPatterns("/url/*");
    registration.addInitParameter("paramName", "paramValue");
    registration.setName("someFilter");
    registration.setOrder(1);
    return registration;
} 

@Bean(name = "someFilter")
public Filter someFilter() {
    return new SomeFilter();
}