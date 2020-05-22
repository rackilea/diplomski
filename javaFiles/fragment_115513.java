public void doPost(HttpServletRequest req,HttpServletResponse resp)
 throws ServletException,IOException{
     String username=req.getParameter("username");
     String password=req.getParameter("password");
     try{
        req.login(username, password);
        PrintWriter out= req.getWriter();
        out.println("<h2>Welcome</h2>");
     } catch(ServletException e ){
        PrintWriter out= req.getWriter();
        out.println(e.getMessage());
     }        
}