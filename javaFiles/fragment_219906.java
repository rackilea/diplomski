@Override
public void configure(WebSecurity web) throws Exception {
    web.ignoring().antMatchers("/css/**", "/js/**", 
            "/app/controllers/**", "/app/partials/**", "/app/*",
            "/", "/index.html", "/favicon.ico");
}