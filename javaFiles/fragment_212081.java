public class UpdateSavedRequestFilter extends OncePerRequestFilter {
    private RequestCache requestCache = new HttpSessionRequestCache();

    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String queryString = request.getQueryString();
        if(!StringUtils.contains(queryString, "code") && authentication == null) {
            requestCache.saveRequest(request, response);
        }
        filterChain.doFilter(request, response);
    }
}