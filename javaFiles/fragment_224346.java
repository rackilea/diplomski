@Bean
public FilterRegistrationBean securityFilter() {
    Filter f = new MySecurityFilter();
    FilterRegistrationBean frb = new FilterRegistrationBean(f);
    frb.setOrder(SecurityProperties.ACCESS_OVERRIDE_ORDER);
    frb.setUrlPatterns(Arrays.asList("/oauth/token"));
    return frb;
}