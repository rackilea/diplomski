public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
    String id = req.getParameter("id");
    String name = getNameFromDBForId(id);
    req.setAttribute("name", name);
    RequestDispatcher rd = getServletContext().getRequestDispatcher("/page.jsp");
    rd.forward(request, response);
}