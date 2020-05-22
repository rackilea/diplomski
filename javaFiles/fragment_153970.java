@Override
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
    HttpSession session = request.getSession(false);

    //session.getAttribute("user") contains the user info in session
    if (session == null || session.getAttribute("user") == null) {
        // No logged-in user found, so redirect to login page.
        response.sendRedirect(request.getContextPath() + "/login");
    } else {
        // Logged-in user found, so just continue request.
        chain.doFilter(req, res); 
    }
}