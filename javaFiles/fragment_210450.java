@Bean
public ProviderManager authenticationManager() {
    return new ProviderManager(Arrays.asList(
        kerberosServiceAuthenticationProvider(),
        samlAuthenticationProvider(),
        pkiAuthenticationProvider(),
        openIdConnectAuthenticationProvider());
}