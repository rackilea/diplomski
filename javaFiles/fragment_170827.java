@Bean 
public static CustomScopeConfigurer customScope() {
    CustomScopeConfigurer configurer = new CustomScopeConfigurer();
    configurer.addScope(CustomerScope.CUSTOMER_SCOPE_NAME, new CustomerScope()); 
    return configurer;
}