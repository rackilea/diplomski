@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends ResourceServerConfigurerAdapter {
    // ...

    @Autowired
    private ResourceServerProperties resource;

    @Autowired
    private CustomAccessTokenConverter customConverter;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.tokenServices(customTokenServices());
        // ..
    }

    private RemoteTokenServices customTokenServices() {
        RemoteTokenServices services = new RemoteTokenServices();
        services.setAccessTokenConverter(this.customConverter);

        // configure based on .properties file 
        services.setCheckTokenEndpointUrl(this.resource.getTokenInfoUri());
        services.setClientId(this.resource.getClientId());
        services.setClientSecret(this.resource.getClientSecret());

        return services;
    }

    // ..