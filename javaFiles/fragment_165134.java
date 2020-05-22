protected void doGet(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
  Map parametersMap = request.getParameterMap();
  if (parametersMap.size() > 0) {
     if (request.getParameter("hub.mode").equals("streamInit")) {
        System.out.println("Verify Token: " + request.getParameter("hub.verify_token"));
        System.out.println("Challenge number:" + request.getParameter("hub.challenge"));

        String responseToClient = request.getParameter("hub.challenge");
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().write(responseToClient);
        response.getWriter().flush();
        response.getWriter().close();

           //"Completed streaming setup on your url" 
     }
  }