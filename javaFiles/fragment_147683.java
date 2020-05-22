<c:choose>
  <c:when test="${not empty sessionScope.executorname}"> //if loop
     <html:select style="width:190;" value="<%=user%>" property="jobOwner">
         <html:option value="${sessionScope.executorname}"><${sessionScope.executorname}></html:option>
     </html:select>
  </c:when>
  <c:otherwise> // else loop
      //do whatever
  </c:otherwise>
</c:choose>