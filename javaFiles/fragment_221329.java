<c:choose>
<c:when test="${fn:length(serviceRequestData)>= 1}">
    // Place the code what you want to do

</c:when>
<c:otherwise>
    // Nothing to display

</c:otherwise>
</c:choose>