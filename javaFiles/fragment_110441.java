<table style="padding-left: 200px;margin-top: 10px;border: 1px">
    <tr>
     <th>Expense title</th>
     <th>Expense amount</th>
     <th>Expense date</th>
     <th>Action</th>
    </tr>
    <c:forEach items="${item}" var="it">
    //the form should be after the for loop
    <form action="/edit" method="post">
    <tr>
     <td><input name="itemname" type="text" required="required" value="it.id"/></td>
     <td><input name="itemprice" type="text" required="required" value="it.itemPrice" />     </td>
     <td><input name="transactiontime" type="date" id="datepicker" required="required" value="it.transactionTime"/></td>
     <td>
      <input type="submit" name="submit" value="update"/>
      <input type="hidden" name="id" value="${it.id}">
     </td>
    </tr>
   //closing from tag
    </form>
  </c:forEach>
 </table>