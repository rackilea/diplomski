@Bean
@Order(1)
public FilterRegistrationBean<MyFilter> myFilter() {
    FilterRegistrationBean<MyFilter> contextFilter = new FilterRegistrationBean<>();
    contextFilter.setFilter(theActualFilter());
    contextFilter.addUrlPattern("/api/*");
    return contextFilter;
}

@Bean 
public MyFilter theActualFilter() {
    return new MyFilter(); // now this is a Spring bean
}