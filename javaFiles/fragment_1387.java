<c:forEach var="entry" items="${M}">  
      <option>${entry.key}</option>  
      <c:forEach var="val" items="${entry.value}">       
           ....
      </c:forEach>
</c:forEach>