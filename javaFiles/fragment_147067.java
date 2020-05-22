<%
if (canModify) {  // This is the JSP variable
%>
  var canModify = true;  // This is the JavaScript variable
<%
} else {
%>
  var canModify = false;
<%
}
%>