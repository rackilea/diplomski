<%
    if(session.getAttribute("email") == null) {
       response.sendRedirect("login.jsp");
       return ;
    }
%>