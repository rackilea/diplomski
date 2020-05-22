public class NoCompatibilityMode implements Filter {

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException,
            ServletException {
        if (((HttpServletRequest) req).getRequestURI().endsWith(".js.jsf")
                || ((HttpServletRequest) req).getRequestURI().endsWith(".css.jsf")) {
            chain.doFilter(req, res);
        } else {
            HttpServletResponse response = (HttpServletResponse) res;
            response.setHeader("X-UA-Compatible", "IE=edge"); // No more Compatibility Mode
            chain.doFilter(req, res);
        }

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
    }

}