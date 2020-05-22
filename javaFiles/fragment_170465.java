<c:forEach items="${vehicles}" var="vehicle">
   Reg.No: ${vehicle.registrationPlateNumber}
   <c:if test="${vehicle.type == 'bus'}">
      Toilets: ${vehicle.toilets}
   </c:if>
</c:forEach>