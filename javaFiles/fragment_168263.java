protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    String name= request.getParameter("name");
    String password= request.getParameter("pass");
    mysqlquery co = new mysqlquery();
    boolean canAuthenticate = co.autenticacion(name, password);
    if(canAuthenticate  && co.getUserRole().equals("admin")){
        //go to admin page
    } else if (canAuthenticate  && co.getUserRole().equals("employee")) {
       //go to employee page
    } else {
        response.sendRedirect("index.jsp");
    }
}