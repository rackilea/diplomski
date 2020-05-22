<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form method="post">
        title: <input type="text" name="title"/><br/>
        author: <select name="author.userId">
                <c:forEach items="${authors}" var="author">
                    <option value="${author.userId}">${author.userName}</option>
                </c:forEach>
            </select>
            <br/>
        content: <input type="text" name="content"/><br/>
        <input type="submit" value="add"/>
    </form>
</body>
</html>