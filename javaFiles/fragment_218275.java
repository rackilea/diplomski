@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    User user = userService.find(username, password);

    if (user != null) {
        request.getSession().setAttribute("user", user);
        response.sendRedirect(request.getContextPath() + "/home");
    } else {
        request.setAttribute("message", "Unknown login. Please retry.");
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
}