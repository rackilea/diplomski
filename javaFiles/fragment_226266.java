public class myAwesomeFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                HttpServletResponse response, FilterChain filterChain)  throws ServletException, IOException {

        response.addHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        response.addHeader("pragma", "no-cache");
        filterChain.doFilter(request, response);
    }
}