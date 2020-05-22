<%    
String error = (String)request.getParameter("error");   
request.removeAttribute("error");   
if(error != null)   
    out.println(error);   
%>