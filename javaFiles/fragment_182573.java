<c:forEach items="${dataSetList}" var="dataSetVar">
    ${dataSetVar.group} <br/>  
    <c:forEach items="${dataSetVar.fruitList}" var="fruit" varStatus="loopCount">                 
        <c:out value="${fruit}" /> 
        <c:out value="${dataSetVar.priceList[loopCount.index]}" />
    </c:forEach>       
</c:forEach>