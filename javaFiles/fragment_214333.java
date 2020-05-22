<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% 
    String[] names = {"Hello", "you", "are", "using", "jstl", "in", "jsp"};
    request.setAttribute("names", names);
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>JSTL demo</title>
    </head>
    <body>
        <table>
            <tr><td>Print</td></tr>
            <c:forEach items="${names}" var="name">
                <tr><td>${name}</td></tr>
            </c:forEach>
        </table>
    </body>
</html>