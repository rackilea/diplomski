<% 
         String name=request.getParameter("uname");
         out.print("Welcome"+name);
         session.setAttribute("user", name);
          <a href ="second.jsp" > second jsp  </a> // html anchor tag
     %>