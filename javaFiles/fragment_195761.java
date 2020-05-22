<c:catch var="errorOccurred">
  <c:set var="grade" value="${(G / (G + L + W + D + A + pc + dc + vc) * 100)}"/>
  </c:catch>

 <c:choose>
 <c:when test="${errorOccurred != null}"> 
    Not applicable
</c:when> 
<c:otherwise> 
 <fmt:formatNumber value="${grade}" pattern="0" var="myInteger"/>
 <c:set var="passed" value="${myInteger - grade eq 0}"/>
    <c:choose>
        <c:when test="${passed}"> 
            <fmt:formatNumber minFractionDigits="2" maxFractionDigits="2"
                                      value="${grade}" />% 
        </c:when> 
        <c:otherwise> 
         Not applicable  
        </c:otherwise>
    </c:choose>
    </c:otherwise> 
    </c:choose>