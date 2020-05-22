protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
   processRequest(request, response);
}
private void processRequest(HttpServletRequest request, HttpServletResponse response){
     int boardSize = Integer.parseInt(request.getParameter("boardSize"));
     int numberOfPlayers = Integer.parseInt(request.getParameter("numberOfPlayers"));
     m_Engine = new Engine(boardSize, numberOfPlayers );

    response.setContentType("text/xml");
    response.setHeader("Cache-Control", "no-cache");

    PrintWriter out = response.getWriter();

    out.write("<board>" + boardSize + "</board>");
    out.flush();
 }