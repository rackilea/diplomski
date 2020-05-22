User user = userDAO.find(username, password);
if (user != null) {
    request.getSession().setAttribute("user", user);
    response.sendRedirect(request.getParameter("from"));
} else {
    // Show error.
}