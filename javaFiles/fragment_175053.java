<%@ taglib prefix=”c” uri=”http://java.sun.com/jsp/jstl/core” %>
<%@ attribute name="studentList" required="true" type="java.util.List" %>

<select class="combobox">
  <c:forEach var="student" items="${studentList}">
    <option value="${student.id}">
      <c:out value="${student.lastName}" />,
      <c:out value="${student.firstName}" />
    </option>
  </c:forEach>
</select>