<c:forEach items="${andares}" var="andar">
    <c:set var="andarval" value="${anar.numero}"/>
    ..........
    <c:forEach items="${lojas}" var="loja">
        <c:set var="lojaval" value="${loja.andar}"/>
        <c:if test="${lojaval == andarval}">
        ....
        </c:if>
    </c:forEach>
</c:forEach>