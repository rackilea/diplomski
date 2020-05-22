<c:choose>
    <c:when test="${rec.image1Available}">
        <img src="/img1.jpg" alt="altname" />
    </c:when>
    <c:otherwise>
        <c:choose>
            <c:when test="${rec.image2Available}">
                 <img src="/img2.jpg" alt="altname" />
            </c:when>
            <c:otherwise>
                <c:choose>
                    <c:when test="${rec.image3Available}">
                        <img src="img3.jpg" alt="altname" />
                    </c:when>
                    <c:otherwise>
                        <img src="/holder.jpg" alt="altname" />
                    </c:otherwise>
                </c:choose>
            </c:otherwise>
        </c:choose>
    </c:otherwise>
</c:choose>