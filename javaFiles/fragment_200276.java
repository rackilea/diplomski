@Configuration
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String GOOGLE_PLUS_DOMAIN_ATTRIBUTE = "domain";
    private static final String CSRF_COOKIE_NAME = "XSRF-TOKEN";
    private static final String CSRF_HEADER_NAME = "X-XSRF-TOKEN";

    @Bean
    public AuthoritiesExtractor authoritiesExtractor(
            @Value("#{'${security.allowed-domains}'.split(',')}") final List<String> allowedDomains) {

        return new AuthoritiesExtractor() {
            @Override
            public List<GrantedAuthority> extractAuthorities(final Map<String, Object> map) {
                if (map != null && map.containsKey(GOOGLE_PLUS_DOMAIN_ATTRIBUTE)) {
                    final String domain = (String) map.get(GOOGLE_PLUS_DOMAIN_ATTRIBUTE);
                    if (!allowedDomains.contains(domain)) {
                        throw new BadCredentialsException("Not an allowed domain");
                    }
                    return AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");
                }
                return null;
            }
        };
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        // @formatter:off
        http.antMatcher("/**")
        .authorizeRequests()
        .antMatchers("/logout", "/api/mappings/**", "/public/**").permitAll()
        .anyRequest().hasAuthority("ROLE_USER")
        .and().logout().logoutUrl("/api/logout").logoutSuccessUrl("/logout")
        .and().csrf().csrfTokenRepository(csrfTokenRepository()).ignoringAntMatchers("/api/mappings/**")
        .and().addFilterAfter(csrfHeaderFilter(), CsrfFilter.class);
        // @formatter:on
    }

    private Filter csrfHeaderFilter() {
        return new OncePerRequestFilter() {
            @Override
            protected void doFilterInternal(final HttpServletRequest request, final HttpServletResponse response,
                    final FilterChain filterChain) throws ServletException, IOException {

                final CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
                if (csrf != null) {
                    Cookie cookie = WebUtils.getCookie(request, CSRF_COOKIE_NAME);
                    final String token = csrf.getToken();
                    if (cookie == null || token != null && !token.equals(cookie.getValue())) {
                        cookie = new Cookie(CSRF_COOKIE_NAME, token);
                        cookie.setPath("/");
                        response.addCookie(cookie);
                    }
                }
                filterChain.doFilter(request, response);
            }
        };
    }

    private CsrfTokenRepository csrfTokenRepository() {
        final HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName(CSRF_HEADER_NAME);
        return repository;
    }
}