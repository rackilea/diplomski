public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
    if (((HttpServletRequest) request).getSession().getAttribute("user") == null) {
        ((HttpServletResponse) response).sendRedirect("login"); // Not logged in, redirect to login page.
    } else {
        chain.doFilter(request, response); // Logged in, just continue request.
    }
}