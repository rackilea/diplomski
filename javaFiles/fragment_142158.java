public class TokenAuthenticationFilter extends GenericFilterBean {

    private AuthenticationManager authenticationManager;

    public TokenAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void doFilter(ServletRequest request,
                                             ServletResponse response,
                                             FilterChain chain) throws IOException, ServletException {

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String apiKey = httpRequest.getHeader("API-Key");
        String token = httpRequest.getHeader("Access-Token");

        try {
            if (!StringUtils.isEmpty(apiKey)) {
                processTokenAuthentication(apiKey);
            }
            chain.doFilter(request, response);
        } catch (InternalAuthenticationServiceException internalAuthenticationServiceException)
        {
            SecurityContextHolder.clearContext();
            logger.error("Internal authentication service exception", internalAuthenticationServiceException);
            httpResponse.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
            catch(AuthenticationException authenticationException)
        {
            SecurityContextHolder.clearContext();
            httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, authenticationException.getMessage());
        }
    }

    private void processTokenAuthentication(String apiKey) {
        SessionCredentials authCredentials = new SessionCredentials(apiKey);
        Authentication requestAuthentication = new PreAuthenticatedAuthenticationToken(authCredentials, authCredentials);
        Authentication resultOfAuthentication = tryToAuthenticate(requestAuthentication);
        SecurityContextHolder.getContext().setAuthentication(resultOfAuthentication);
    }

    private Authentication tryToAuthenticate(Authentication requestAuthentication) {
        Authentication responseAuthentication = authenticationManager.authenticate(requestAuthentication);
        if (responseAuthentication == null || !responseAuthentication.isAuthenticated()) {
            throw new InternalAuthenticationServiceException("Unable to authenticate Domain User for provided credentials");
        }
        return responseAuthentication;
    }
}

public class TokenAuthenticationProvider implements AuthenticationProvider {

    private String apiKey;

    public TokenAuthenticationProvider(String apiKey) {
        this.apiKey = apiKey;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SessionCredentials credentials = (SessionCredentials) authentication.getCredentials();
        if (credentials != null && credentials.apiKey.equals(this.apiKey)) {

            //Also evaluate the token here

            Authentication newAuthentication = new PreAuthenticatedAuthenticationToken(apiKey, credentials);
            newAuthentication.setAuthenticated(true);
            return newAuthentication;
        }
        throw new BadCredentialsException("Bad credentials given.");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(PreAuthenticatedAuthenticationToken.class);
    }
}