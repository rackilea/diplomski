protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String username = request.getParameter("username");
    String password = request.getParameter("password");
    User user = userService.find(username, password);

    if (user != null) {
        request.getSession().setAttribute("user", user); // Login user.
        response.sendRedirect("home"); // Redirect to home page.
    } else {
        request.setAttribute("message", "Unknown username/password. Please retry."); // Store error message in request scope.
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response); // Forward to JSP page to redisplay login form with error.
    }
}