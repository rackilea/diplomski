<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
     pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<c:url value="/Product" var="pdctServletUrl"/>
Product Page
<form method="post" action="${pdctServletUrl}">
    <h4>Enter New Movie details:</h4>

    <label>Name</label>
    <input type="text" name="movie"/>

    <label>Rating</label>
    <input type="text" name="rating"/>

    <label>Year</label>
    <input type="text" name="year"/>

    <label>Price</label>
    <input type="text" name="price"/>

    <input type="submit" value="save movie"/>
</form>
<br/>
To get a list of products click 
<a href="${pdctServletUrl}">Get Products</a>   

<c:if test="${not empty products}">
<h4>Available Products.</h4>
<table>
    <tr>
        <th>Movie Name</th>
        <th>Rating</th>
        <th>Year</th>
        <th>Price</th>
    </tr>
    <c:forEach items="${products}" var="pd">
        <tr>
            <td>${pd.movie}</td>
            <td>${pd.rating}</td>
            <td>${pd.year}</td>
            <td>${pd.price}</td>
        </tr>
    </c:forEach>
</table>
</c:if>

</body>
</html>