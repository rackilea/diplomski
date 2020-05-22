<ul>
<c:forEach var="dn" begin="1" end="${daysInMonth}" step="1">
  <li>
    <c:set var="dnplus3" value="${dn+3}" />
    dn=<c:out value="${dn}" />
    dnplus3=<c:out value="${dnplus3}" />
    class=<c:out value="${dnplus3.class.name}" />
  </li>
</c:forEach>
</ul>