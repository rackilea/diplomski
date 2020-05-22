@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) {
    handleGetAndPost(request, response);
}

@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) {
    handleGetAndPost(request, response);
}

private void handleGetAndPost(HttpServletRequest request, HttpServletResponse response) {
   if ("profile".equals(request.getParameter("param")) {
       response.sendRedirect("profile.jsp");
   } else if ("editProf".equals(request.getParameter("param")) {
       response.sendRedirect("editProfile.jsp");
   } 
}