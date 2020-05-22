@Bean
public FilterRegistrationBean registration() {
        DelegatingFilterProxy filter = filter(); // or inject it with a @Qualifier
    FilterRegistrationBean registration = new FilterRegistrationBean(filter);
    registration.setEnabled(false);
    return registration;
}