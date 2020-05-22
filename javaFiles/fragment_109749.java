public class LoginAction implements Action {

    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userDAO.find(username, password);

        if (user != null) {
            request.getSession().setAttribute("user", user); // Login user.
            return "home"; // Redirect to home page.
        }
        else {
            request.setAttribute("error", "Unknown username/password. Please retry."); // Store error message in request scope.
            return "login"; // Go back to redisplay login form with error.
        }
    }

}