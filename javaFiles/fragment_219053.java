protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    response.setContentType("text/html");
    response.setStatus(HttpServletResponse.SC_OK);
    response.getWriter().println("<h1>"+greeting+"</h1>");
    response.getWriter().println("session=" + request.getSession(true).getId());
}