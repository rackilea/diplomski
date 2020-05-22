<tr style = "height:30px;padding:4px">
 <c:forEach var = "item" items = "${obj.allusers}" varStatus="loopStatus">     
  <c:if test="${loopStatus.index < 2}">
    <td><div align = "center">${item}</div><td>
  </c:if>    
 </c:forEach>
</tr>