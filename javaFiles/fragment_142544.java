<%@page import="Test.Manager" %>
<%
    Manager o = new Manager();
    String output = o.run();
%>
<%= output %>