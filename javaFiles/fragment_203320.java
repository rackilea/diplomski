@Override
public void doFilter(ServletRequest request, ServletResponse response,
    FilterChain filterChain) throws IOException, ServletException {

    Boolean filtered = false;
    System.out.println("request intercepted");
    if (!filtered) {
        filtered = true;
        ((HttpServletResponse) response).sendRedirect("/Servlet1");
        return;
    }

    filterChain.doFilter(request, response);
}