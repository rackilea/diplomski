@EnableWebSecurity
@EnableResourceServer
@EnableAuthorizationServer
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    public void configure( final WebSecurity web ) throws Exception {
        web.ignoring()
                .antMatchers( "/", "/index.html", "/partials/**/*.html" )
                .antMatchers( "/webjars/**/*.js" )
                .antMatchers( "/webjars/**/*.css" );
    }

    @Override
    protected void configure( final HttpSecurity http ) throws Exception {
        super.configure( http );
    }

}