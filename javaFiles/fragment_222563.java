<div id="accordion">
    <c:forEach items="${allList}" var="myLs">
        <h3>${myLs.key}</h3>
        <div>
            <c:forEach var="item" items="${myLs.value}">
                ${item.foo}, ${item.bar}  <br/>
            </c:forEach>
        </div>
    </c:forEach>
</div>