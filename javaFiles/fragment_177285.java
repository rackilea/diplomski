<forEach ....>
<table>
<c:forEach items="${ce}" var="contractEntitlement">
    <c:if test="${contractHeader.id ==  contractEntitlement.chId}" >
    Display TR
    Display TD .... END OF DISPLAY TD
    Display TR, end of
    </c:if>
</c:forEach>
</table>
</forEach ...>