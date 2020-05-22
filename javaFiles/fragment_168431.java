<c:forEach begin="1" end="$MyMap['noOfPages']" var="i" varStatus="loop">
    <c:choose>
        <c:when test="${currentPage eq i}">
            ${i}
        </c:when>
        <c:otherwise>
            <a href="/detailssection/id?pagenumber=${loop.index}">${loop.index}</a>
        </c:otherwise>
    </c:choose>
</c:forEach>