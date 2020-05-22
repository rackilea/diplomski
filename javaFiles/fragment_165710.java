<form method="POST" action="${url_save}" modelAttribute="sprav">
  <tr>
    <c:forEach var="columnName" items="${sprav.columnName}">                                             
      <td><input name="column[]"></input></td>                                      
   </c:forEach>
  </tr>
  <tr>
    <td><input type="submit" value="submit"></input></td>
  </tr>
</form>