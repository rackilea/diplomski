//Set object on one jsp:
<%
Hello hello = new Hello();
session.setAttribute("helloObject", hello);
%>

//Get object on second jsp:
<%
Hello helloObject = (Hello)session.getAttribute("helloObject");
%>