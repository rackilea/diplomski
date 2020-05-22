<c:choose>
    <c:when test="${company eq 'multi'}">
        <a href="dashResumo.jsp?tr=<%=tr%>&company=VVO&nm=<%=nmTorr%>">VVO</a>
        <a href="dashResumo.jsp?tr=<%=tr%>&company=GPA&nm=<%=nmTorr%>">GPA</a>                                    
    </c:when>
</c:choose>