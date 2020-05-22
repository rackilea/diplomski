<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
<form method="POST" action="testservlet">
    <p> Choose a Hobby:
    </p>
    <select name="hobby" size="1">
        <option>horse skiing
        <option>extreme knitting
        <option>alpine scuba
        <option>speed dating
    </select>
    <br><br>
    <center>
        <input type="SUBMIT">
    </center>
</form>
</body>
</html>