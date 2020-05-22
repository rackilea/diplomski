<%
String phoneno=null;
if(request.getAttribute("phoneno")!=null) 
    phoneno = request.getAttribute("phoneno").toString();
%>

<% if(phoneno!=null) {
     out.println("<INPUT TYPE=\"text\" name=\"phoneno\" value=\""+phoneno+"\" disabled=\"disabled\" ");
   } else {
       out.println("<INPUT TYPE=\"text\" name=\"phoneno\" ");
   }
%>