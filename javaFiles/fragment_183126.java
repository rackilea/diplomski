<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<body>
    <h1>${message}</h1>

<form:form modelAttribute="pojo" method="post" action="paramiter/create">
    <div>
        <form:select path="ftpConnection">
            <form:options items="${ftpList}" itemLabel="description" />
        </form:select>
    </div>
    <button> Submit</button>
</form:form>
</body>
</html>