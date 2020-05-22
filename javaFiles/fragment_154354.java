<%@taglib  prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
    <%@taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@attribute name="table" required="true"%>    
    <sql:query var="temporary">
        select * from ${table}
    </sql:query>
    <table border="1">
        <tr>
            <c:forEach items="${temporary.columnNames}" var="temporary_value">
                <th>${temporary_value}</th>
            </c:forEach>
        </tr>
        <c:forEach items="${temporary.rowsByIndex}" var="temporary_row">

            <tr>
                <c:forEach items="${temporary_row}" var="temporary_value">
                    <td>${temporary_value}</td>
                </c:forEach>
            </tr>
        </c:forEach>
    </table>