@Override
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
    HttpSession session = request.getSession(false);
    User user = (session != null) ? (User) session.getAttribute("user") : null;

    if (user == null || !user.isLoggedIn()) {
        response.sendRedirect("/login.xhtml"); // No logged-in user found, so redirect to login page.
    } else {
        chain.doFilter(req, res); // Logged-in user found, so just continue request.
    }
}