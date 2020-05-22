<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="mypackage.*" %>
<%@ page import="java.util.*" %>
<%@ page import="flexjson.JSONSerializer.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

<%
    String id = request.getParameter("id");
    String json = new JsonArrayGenerator(id).getJsonArray();
%>

<script>
var array = <%=json%>;
alert(array.toString());
</script>
</body>
</html>