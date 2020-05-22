@Configuration
@EnableAuthorizationServer
public class AuthServerConfig extends AuthorizationServerConfigurerAdapter {
    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        oauthServer
            .tokenKeyAccess("isAuthenticated()")
            .checkTokenAccess("isAuthenticated()");

        // override the default basic authentication filter in order to provide
        // a custom authentication manager
        oauthServer.addTokenEndpointAuthenticationFilter(new BasicAuthenticationFilter(authenticationManager, new BasicAuthenticationEntryPoint()));
    }
}