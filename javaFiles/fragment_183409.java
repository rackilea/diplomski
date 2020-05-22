@Override
public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) {
    HttpServletResponseWrapper wrapper = new MyHttpServletResponseWrapper(resp);
    chain.doFilter(req, wrapper);
}

private static class MyHttpServletResponseWrapper extends HttpServletResponseWrapper {
    ...
}