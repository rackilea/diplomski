<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
...
<table>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.name}</td>
            <td>${product.description}</td>
            <td>${product.price}</td>
        </tr>
    </c:forEach>
</table>