<%@ page import="com.acme.MyModel" %>
<%
    MyModel myModel= (MyModel) request.getAttribute("myModel");
%>
<html>
    <head></head>
    <body>
        Model: <%= myModel.value %>
    </body>
</html>