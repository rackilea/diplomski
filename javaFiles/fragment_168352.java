@Configuration
@EnableWebSecurity
public class OAuth2ServerConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private TokenStore tokenStore;

    private static DataSource dataSource;
    @Autowired
    private void setDataSource(DataSource dataSourcee) {
        dataSource = dataSourcee;
    }

//... SOME MORE CODE ...

@Configuration
@Order(1)
protected static class AuthorizationServerConfiguration extends
        OAuth2AuthorizationServerConfigurerAdapter {

    private TokenStore tokenStore = new JdbcTokenStore(dataSource);