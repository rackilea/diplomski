User user = userDAO.find(username, password);
if (user != null) {
    session.setAttribute("user", user);
    response.sendRedirect(request.getParameter("from"));
} else {
    request.setAttribute("error", "Unknown login");
    request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
}