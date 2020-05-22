public final class MyExceptionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) {
        try {
            // forward request to subsequent filter/resource/servlet
            filterChain.doFilter(request, response);
        } catch ( Throwable ex ) {
            // do whatever you want in case any exception occurred and not caught in the request processing class
            // forward request to error page
            request.getRequestDispatcher("/ErrorPage.jsp").forward(request, response);
        }
    }

    @Override
    public void destroy() {
    }

}