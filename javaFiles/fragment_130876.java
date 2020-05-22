public class AuthFailureFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        try {
            chain.doFilter(request, response);
        } catch (ExpiredJwtException | SignatureException exception) {
            handle(exception);
        }
    }
}