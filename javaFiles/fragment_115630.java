public void doGet(HttpServletRequest request,HttpServletResponse response)  
throws ServletException,IOException  
{  
 //creating ServletContext object  
ServletContext context=getServletContext();  

//Getting the value of the initialization parameter and printing it  
String paramName=context.getInitParameter("paramName");   
}