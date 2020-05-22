import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.NegatedRequestMatcher;

// snip...

@Override
protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
                .antMatchers("/login", "/assets/**").permitAll()
                .anyRequest().authenticated()
            .and()
                .exceptionHandling()
                .defaultAuthenticationEntryPointFor(new HttpStatusEntryPoint(HttpStatus.NOT_FOUND),
                        new NegatedRequestMatcher(new AntPathRequestMatcher("/login")) )
            .and()
                .formLogin()
            ;
}