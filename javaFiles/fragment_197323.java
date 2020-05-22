String username = request.getParameter("username");
String password = request.getParameter("password");
User user = userService.find(username, password);

if (user != null) {
    request.getSession().setAttribute("user", user); // Login user.
    response.sendRedirect("userhome"); // Redirect to user home page.
} else {
    request.setAttribute("errormessage", "Unknown login, try again"); // Set error message.
    request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response); // Redisplay login form.
}