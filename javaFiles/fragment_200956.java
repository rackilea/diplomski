public class JQueryArrayParameterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        /* empty */
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(new JQueryArrayParameterRequestWrapper((HttpServletRequest) request), response);
    }

    @Override
    public void destroy() {
        /* empty */
    }
}