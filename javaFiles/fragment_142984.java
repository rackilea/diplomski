public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
    if (request.getCharacterEncoding() == null) {
        request.setCharacterEncoding("gb2312");
    }
    chain.doFilter(request, response);
}