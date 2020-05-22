@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

....

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
....
            .requestMatcher(new RequestHeaderRequestMatcher("Authorization"))
....