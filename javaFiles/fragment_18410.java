public class AuthenticationFilter implements Filter {
@Override
public void init(FilterConfig filterConfig) throws ServletException {

}

@Override
public void destroy() {

}


@Override
public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) servletRequest;
    HttpServletResponse response = (HttpServletResponse) servletResponse;
    UserDaoImpl dao = new UserDaoImpl();
    String login = request.getParameter("login");
    String password = request.getParameter("password");
    int id = dao.findByLogin(login, password);

    User user = dao.findById(id);

    HttpSession session = request.getSession();

    if (nonNull(session) && nonNull(session.getAttribute("user"))) {
        User role = (User) session.getAttribute("user");
        moveToMenu(request, response, role.getRole());
    } else if (dao.userIsExist(login, password)) {
        User.ROLE role = dao.getRoleByLoginPassword(login, password);
        request.getSession().setAttribute("user", user);
        moveToMenu(request, response, role);
    } else {
        moveToMenu(request, response, User.ROLE.UNKNOWN);
    }
}

private void moveToMenu(HttpServletRequest req, HttpServletResponse res, User.ROLE role) throws ServletException, IOException {
    if (role.equals(User.ROLE.ADMIN)) {
        req.getRequestDispatcher("/WEB-INF/view/adminPage.jsp").forward(req, res);
    } else if (role.equals(User.ROLE.USER)) {
        req.getRequestDispatcher("/WEB-INF/view/userPage.jsp").forward(req, res);
    } else {
        req.getRequestDispatcher("/WEB-INF/view/index.jsp").forward(req, res);
    }
}