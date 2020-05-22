public class MyServlet extends HttpServlet {  

    public void doGet(HttpServletRequest request, HttpServletResponse response){  
    try{  


    String n=request.getParameter("userName");  

    HttpSession session=request.getSession();  
    session.setAttribute("uname",n);  

    //code

   }catch(Exception e){System.out.println(e);}  
  }  

 }