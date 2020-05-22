@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    processRequest(request, response);

    String login = request.getParameter("login");
    String password = request.getParameter("password");
}