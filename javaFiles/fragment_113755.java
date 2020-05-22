<!-- at the beginning of the JSP, call the JSTL library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<form action="RecordServlet" method="POST">
    Please select an element:
    <select id="selectedRecord" name="selectedRecord">
        <c:forEach items="${records}" var="record">
        <option value="${record}">${record}</option>
        </c:forEach>
    </select>
    <br />
    <input type="submit" value="Show selected record" />
    <c:if test="${not empty selectedRecord}">
        <br />
        You've selected ${selectedRecord}!
    </c:if>
</form>