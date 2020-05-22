protected void processRequest(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    HttpSession ses=request.getSession();//let it be always created for this
    boolean logged=ses.getAttribute("logged")==Boolean.TRUE;
    //Redirects to LoginController.java if there is no session
    if(logged){
        response.sendRedirect("/login-controller");
        return;//you cannot do anything with the request/response once it's redirected or forwarded.
    }else{
        PrintWriter out = response.getWriter();
        out.print("Logout to login again!");
    }
}