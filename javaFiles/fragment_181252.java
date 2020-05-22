<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>

<sec:authentication property="principal" var="auth" scope="session" />

<html>
<body>
<h2>Hello World!</h2>
<h2>${auth }</h2>
<form action="<c:url value='/login' />" method="POST">
    Username：<input type="text" name="username" /><br/>
    Password：<input type="password" name="password" /><br/>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/> <br/>
    <input type="submit" value="Login" />
</form>
</body>
</html>