public class DoFilterChainFilter implements Filter {
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(request, response);
    }
    public void destroy() { }
    public void init(FilterConfig filterConfig) throws ServletException { }
}