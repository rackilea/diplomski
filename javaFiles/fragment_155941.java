<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:forEach items="${arr}" var="cursor" varStatus="itemsRow">
  <c:set name="val" value="${cursor.value < 0 ? cursor.value * -1 : cursor.value}"/>
  <td width="75px" align="right">
    <fmt_rt:formatNumber pattern="#,###,###,###.##" value="${val}" minFractionDigits="2"/>
  </td>
</c:forEach>