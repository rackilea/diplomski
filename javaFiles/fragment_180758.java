<%
Integer sessionCount = (Integer) application.getAttribute("SESSION_COUNT");//fetching session count from application scope
if(sessionCount!=null && sessionCount>2){
    response.sendRedirect("Error.jsp");//redirection code
}
%>