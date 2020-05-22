<%@page import="com.google.gson.Gson"%>
<%@page import="com.learnkeeper.server.ServiceImpl"%>
<%@page import="com.google.gwt.user.server.rpc.RPC"%>
<%@page import="com.learnkeeper.shared.entities.User"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<%
  Object user = request.getSession().getAttribute("user");
  String serialized_user = new Gson().toJson(RPC.encodeResponseForSuccess(ServiceImpl.class.getMethod("getUser"), user).substring("//OK".length()));
%>
<script type="text/javascript">var serialized_user=<%=serialized_user%>;</script>
</head>
<body>