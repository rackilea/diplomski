@Bean
public FilterRegistrationBean<CORSFilter> corsFilterRegistration() {
    FilterRegistrationBean<CORSFilter> filterRegistrationBean =
        new FilterRegistrationBean<>(corsFilter());
    filterRegistrationBean.setUrlPatterns(Collections.singleton("/getToken"));
    return filterRegistrationBean;
}

@Bean
public CORSFilter corsFilter() {
    return new CORSFilter();
}