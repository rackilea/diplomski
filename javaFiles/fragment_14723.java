<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<jsp:useBean id="sBean" scope="session" class="my.project.SessionBean" />
<%@ page import="my.project.SessionBean" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<p>page 2</p>
<p>from jsp tag</p>
<jsp:getProperty name="sBean" property="name" /><br />

<p> from scriptlet</p>
<%
SessionBean testBean = (SessionBean) session.getAttribute("sBean");
out.print(testBean.getName());
%>

</body>
</html>