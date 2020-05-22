public class CacheHeaderFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain filterChain) throws IOException, ServletException {
        String uri = ((HttpServletRequest)req).getRequestURI();
        if (uri.contains(".cache.")) {
            ((HttpServletResponse)res).setDateHeader("Expires",
                System.currentTimeMillis() + 31536000000L);
        } else if (uri.contains(".nocache.")) {
            ((HttpServletResponse)res).setHeader("Cache-Control", "no-cache");
        }
        filterChain.doFilter(req, res);
    }
...
}