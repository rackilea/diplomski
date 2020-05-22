@Bean
    public Wss4jSecurityInterceptor securityInterceptor() {
    Wss4jSecurityInterceptor securityInterceptor = new   Wss4jSecurityInterceptor();
    securityInterceptor.setSecurementActions("UsernameToken");
    securityInterceptor.setSecurementUsername({username});
    securityInterceptor.setSecurementPassword({password});
    securityInterceptor.setSecurementPasswordType("PasswordText");
    securityInterceptor.setSecurementUsernameTokenElements("Created");
    return securityInterceptor;