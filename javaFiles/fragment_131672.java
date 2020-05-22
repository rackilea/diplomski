<c:forEach var="results" items="${groupAlphaInfoVO}">
       <c:out value="${results.userid}"></c:out>
       <c:out value="${results.password}"></c:out>
       <c:out value="${results.role}"></c:out>
       <c:out value="${results.contact}"></c:out>
       <c:out value="${results.mentor}"></c:out>
       <c:out value="${results.group}"></c:out>
</c:forEach>