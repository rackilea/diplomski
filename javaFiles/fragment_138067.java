<c:forEach items="${commentNames}" var="comment" varStatus="commentLoop">     
    ${comment}
    <c:forEach items="${rates}" var="rate" varStatus="rateLoop">
        <c:if test="${commentLoop.index == rateLoop.index}">
            ${rate}
        </c:if>
    </c:forEach> 
</c:forEach>