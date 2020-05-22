public class SecurityFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest httpRequest,
                                    HttpServletResponse httpResponse,
                                    FilterChain filterChain) throws ServletException, IOException {
        httpResponse.setHeader("X-FRAME-OPTIONS", "DENY");
        filterChain.doFilter(httpRequest, httpResponse);
    }
}