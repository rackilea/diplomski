@Bean
FilterRegistrationBean multiReadFilter() {
    FilterRegistrationBean registrationBean = new FilterRegistrationBean();
    MultiReadRequestFilter multiReadRequestFilter = new MultiReadRequestFilter();
    registrationBean.setFilter(multiReadRequestFilter);
    registrationBean.setOrder(SecurityProperties.DEFAULT_FILTER_ORDER - 2);
    registrationBean.setUrlPatterns(Sets.newHashSet("/path/here"));
    return registrationBean;
}