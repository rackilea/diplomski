@ComponentScan
@EnableAutoConfiguration
public class Application {

public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
}

@Configuration
@Order(Ordered.LOWEST_PRECEDENCE - 100)
protected static class OAuth2Config extends OAuth2AuthorizationServerConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // @formatter:off
        auth.apply(new InMemoryClientDetailsServiceConfigurer())
            .withClient("my-trusted-client")
                .authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
                .authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
                .scopes("read", "write", "trust")
                .accessTokenValiditySeconds(60)
        .and()
            .withClient("my-client-with-secret")
                .authorizedGrantTypes("client_credentials")
                .authorities("ROLE_CLIENT")
                .scopes("read")
                .secret("secret");
    // @formatter:on
    }

}

}