<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.ArrayList"%>

<%
Gson gson = new Gson();
ArrayList list = gson.fromJson(request.getReader(), ArrayList.class);
// ...
%>