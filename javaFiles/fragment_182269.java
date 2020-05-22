HttpSession session = request.getSession();//getting session
     String msg;
   //checking if msg is not null 
      if(session.getAttribute("msg")!=null){
         msg= (String)session.getAttribute("msg");
        out.println("<p style='color:green;'> "+msg+"</p>"); //printing message
       }