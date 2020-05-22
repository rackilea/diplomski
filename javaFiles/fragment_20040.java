<sql:setDataSource var="dataSource" 
    driver="com.microsoft.sqlserver.jdbc.SQLServerDriver"
    url="jdbc:sqlserver://localhost:1433;databaseName=test" 
    user="" password="" />

<sql:query dataSource="${dataSource}"
    sql="SELECT username from test where username=?" var="result">
    <sql:param value="${param.username}"></sql:param>
</sql:query>

<table width="100%" height="600" border="1" align="center">
    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td><b>${row.username}</b></td>
        </tr>
    </c:forEach>
</table>