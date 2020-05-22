if (((HttpServletRequest) request).getSession().getAttribute("user") == null) {
    // Not logged in, redirect to login page.
    response.sendRedirect("login.jsf");
} else {
    // Logged in, just continue with request.
    chain.doFilter(request, response);
}