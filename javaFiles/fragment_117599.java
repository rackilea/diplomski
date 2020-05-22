@Bean
    public FilterRegistrationBean registration(PreAuthenticationFilter filter) {
      FilterRegistrationBean registration = new FilterRegistrationBean(filter);
      registration.setEnabled(false);
      return registration;
}