public class JWTFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
        throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
// Here go your implementation
        String jwt = resolveToken(httpServletRequest);
        if (isTokenValid(jwt)) {
            Authentication authentication = getAuthenticationFromToken(jwt);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("YOUR-AUTHORIZATION-HEADER");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }