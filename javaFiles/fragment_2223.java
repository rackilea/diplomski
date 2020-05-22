@Bean
public LocalValidatorFactoryBean localValidatorFactoryBean() {
    return new LocalValidatorFactoryBean();
}

@Bean
public ValidatingMongoEventListener validatingMongoEventListener(LocalValidatorFactoryBean lfb) {
    return new ValidatingMongoEventListener(lfb);
}