@Override
public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;
    HttpSession session = request.getSession(false);
    User user = (session != null) ? (User) session.getAttribute("user") : null;
    String loginURL = request.getContextPath() + "/login"; 

    if (user == null && !request.getRequestURI().equals(loginURL)) {       
        response.sendRedirect(loginURL);
    } else {
        chain.doFilter(request, response);
    }
}