<%
try
{
mysql a =new mysql();
String time=pageContext.getAttribute("time"); 
String day=pageContext.getAttribute("day"); 
String sala=pageContext.getAttribute("sala"); 

 String getData=a.getData(time,day,sala);
 }
catch (Exception ex){  return ex.toString();}  
pageContext.setAttribute("getData", getData);
%>
<c:out value="${getData}"/>