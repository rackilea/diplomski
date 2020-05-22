public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException { 
    if (((HttpServletRequest) request).getSession().getAttribute("user") == null) {
        ((HttpServletResponse) response).sendRedirect("error.jsf"); // Not logged in, so redirect to error page.
    } else {
        chain.doFilter(request, response); // Logged in, so just continue.
    }
}