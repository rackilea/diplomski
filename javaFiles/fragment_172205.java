<c:forEach var="item" items="${openOrders}">
 <form>  
    <tr>             
      <td>
          <input name="getOrder" type="submit" value="- Coffee Order ${item.id}"/>
          <input type="hidden" name="getOrderID" value="${item.id}">     
      </td>
    </tr>
  </form> 
</c:forEach>