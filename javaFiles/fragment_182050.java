public void doFilter(ServletRequest request, ServletResponse response,
        FilterChain chain) throws IOException, ServletException {
    // skip non-http requests
    if (!(request instanceof HttpServletRequest)) {
        chain.doFilter(request, response);
        return;
    }

    HttpServletRequest httpRequest = (HttpServletRequest) request;
    httpRequest.getSession().invalidate();
    ...