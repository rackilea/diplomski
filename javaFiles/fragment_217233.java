<% boolean is_IE6 = request.getHeader("user-agent").indexOf("MSIE 6.") > -1;
   if(is_IE6) { %>
  Some IE 6 Thing
<% } else { %>
  Some non IE 6 Thing
<% } %>