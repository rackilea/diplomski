public class AuthenticationTokenProcessingFilter extends OncePerRequestFilter {
...

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse ress, FilterChain chain) throws IOException, ServletException {

        String agent = req.getHeader("User-Agent");
        SecurityManager.setAgent(agent);

        ...
        try {
            chain.doFilter(request, response);
        } finally {
            SecurityManager.clearManager();
        }
    }
}