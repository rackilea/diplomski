<forEach ....>   
<c:forEach items="${ce}" var="contractEntitlement">
    <c:if test="${contractHeader.id ==  contractEntitlement.chId}" >
    <table>
    Display TR
    Display TD .... END OF DISPLAY TD
    Display TR, end of
    </table>
    </c:if>       
</c:forEach>   
</forEach ...>