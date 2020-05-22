<c:forEach var="widget" items="${widgets}">
    <p><h2>Widget</h2></p>
    <p>IDType: ${widget.id}</p>
    <p>Name: ${widget.name}</p>  
    <img src="chart-servlet.png?id=${widget.id}"/>
    <img src="image-servlet.png?id=${widget.id}"/>
</c:forEach>