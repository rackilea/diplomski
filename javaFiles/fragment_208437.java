@Component
public class MockUserFilter extends GenericFilterBean {

    @Autowired
    private UserDetailsService userDetailsService;

    private SecurityContext securityContext;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (securityContext != null) {
            SecurityContextRepository securityContextRepository = WebTestUtils.getSecurityContextRepository(request);

            HttpRequestResponseHolder requestResponseHolder = new HttpRequestResponseHolder(request, response);
            securityContextRepository.loadContext(requestResponseHolder);

            request = requestResponseHolder.getRequest();
            response = requestResponseHolder.getResponse();

            securityContextRepository.saveContext(securityContext, request, response);

            securityContext = null;
        }
        chain.doFilter(request, response);
    }

    public void authenticateNextRequestAs(String username) {
        UserDetails principal = userDetailsService.loadUserByUsername(username);
        Authentication authentication = new UsernamePasswordAuthenticationToken(principal, principal.getPassword(), principal.getAuthorities());
        securityContext = SecurityContextHolder.createEmptyContext();
        securityContext.setAuthentication(authentication);
    }
}