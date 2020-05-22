response.setContentType("text/html");  
 PrintWriter out = response.getWriter();  
 out.println("<html>");
 out.println("<body>");
 if(yourcondition){
   <p style="display:none;"></p>
 }else{
   <p></p>
 }
 out.println("</body>");
 out.println("</html>");