<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form commandName="command">
    <form:select path="result">
        <form:options items="${fooResults}" itemLabel="result" itemValue="result"/>
    </form:select>
    <input type="submit" value="submit"/>
</form>