if (currentUser.isAuthenticated()) {  
      if (currentUser.hasRole("admin")) {
          response.sendRedirect("app/admin/adminpage.jsp");
      }
      else if (currentUser.hasRole("student") || currentUser.hasRole("admin")) {           
         response.sendRedirect("app/student/studentpage.jsp");         
      }
     else if (currentUser.hasRole("teacher") || currentUser.hasRole("admin")) {      
         response.sendRedirect("app/teacher/teacherpage.jsp");
     }
  } 
 else {
         response.sendRedirect("app/login.jsp");
   }