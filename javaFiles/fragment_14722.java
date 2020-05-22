<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page import="my.project.SessionBean" %>
<jsp:useBean id="sBean" scope="session" class="my.project.SessionBean" />


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
SessionBean testBean = (SessionBean) session.getAttribute("sBean");
testBean.setName("Nate");
pageContext.forward("test2.jsp"); //forward to test2.jsp after setting name

%>
<jsp:getProperty name="sBean" property="name" />

</body>
</html>