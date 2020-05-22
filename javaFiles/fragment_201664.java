<c:forEach items="${ctx.model.customerAttributes}" var="customerAttribute">
<tr>
    <c:set var="WRTSC" value="" />
    <c:set var="DTA" value="" />
    <c:set var="DTA_PRZEDST_TR_OSW" value="" />

    <c:forEach items="${customerAttribute.attributes}" var="attribute">
        <c:if test="${WRTSC eq ''}">
            <c:set var="WRTSC" value="${attribute.attrName == 'WRTSC' ? attribute.attrValue : ''}" />
        </c:if>
        <c:if test="${DTA eq ''}">
            <c:set var="DTA" value="${attribute.attrName == 'DTA' ? attribute.attrValue : ''}" />
        </c:if>
        <c:if test="${DTA_PRZEDST_TR_OSW eq ''}">
            <c:set var="DTA_PRZEDST_TR_OSW" value="${attribute.attrName == 'DTA_PRZEDST_TR_OSW' ? attribute.attrValue : ''}" />
        </c:if>
    </c:forEach>

    <td class="code">${customerAttribute.subGroupName}</td>
    <td class="value">${WRTSC}</td>
    <td class="value">${DTA}</td>
    <td class="value">${DTA_PRZEDST_TR_OSW}</td>
</tr>
</c:forEach>