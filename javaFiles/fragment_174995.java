<form:form action="/spae/welcome" modelAttribute="action" method="post" id="myform" >
    <input type="image" src="/spae/resources/images/img.png" id="image"
           value="expand_2" style="width:20px;height:20px;" />
    <form:input type="hidden" path="id" id="hiddenId"/>
    <input type="submit"/>

</form:form>