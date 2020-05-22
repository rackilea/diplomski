<c:if test="${empty phoneno}">
    <INPUT TYPE="text" name="phoneno" value="${phoneno}" disabled="disabled"/>
</c:if>
<c:if test="${not empty phoneno}">
    <INPUT TYPE="text" name="phoneno"/>
</c:if>