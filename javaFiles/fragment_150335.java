<c:forEach items="${components}" var="component">                           

makeComponent("${component.name}","images/55x55.png","green",
        [
             <c:forEach items ="${component.inputPorts}" var="port" varStatus="loop">

                makePort("${port.portName}", ${port.acceptability})
                <c:if test="${!loop.last}">,</c:if>

             </c:forEach>
        ],
        [
            <c:forEach items ="${component.outputPorts}" var="port">
            makePort("${port.portName}", ${port.acceptability})
            <c:if test="${!loop.last}">,</c:if>

         </c:forEach>
        ]);