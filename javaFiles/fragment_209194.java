<select name='subject'>
    <c:forEach items="${subjects}" var="subject" >                  
        <option value="${subject.key}">
            ${subject.value.getName()}
        </option>                    
    </c:forEach>
</select>