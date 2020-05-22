@Override
public void doFilter(ServletRequest request, ServletResponse response,
    FilterChain filterChain) throws IOException, ServletException {

    Boolean filtered = false;
    System.out.println("request intercepted");
    if (request.getAttribute("filtered") != null) {
        filtered = (Boolean) request.getAttribute("filtered");
    }

    if (!filtered) {
        request.setAttribute("filtered", Boolean.TRUE);
        ((HttpServletResponse) response).sendRedirect("/Servlet1");
        return;
    }

    filterChain.doFilter(request, response);
}