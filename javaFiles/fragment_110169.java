<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
...
<select name="carrierCode">
  <c:forEach items="${carrierCodes}" var="carrierCode">
    <option value="${carrierCode.mfCode}">${carrierCode}</option>
  </c:forEach>
</select>