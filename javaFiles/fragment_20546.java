<%
int idCounter=1;
while(resultSet.next()){
%>
    <tr bgcolor="#DEB887">

        <td><%=resultSet.getString("productid") %></td>
        <td><%=resultSet.getString("productname") %></td>
        <td><%=resultSet.getInt("price") %></td>
        <td><%=resultSet.getString("quantity") %></td>
        <td><%=resultSet.getString("totalprice") %></td>
        <td><button id="addToCartButtonId<%=idCounter%>"  type="button" onclick="addToCart()">Add to Cart</button></td>
    </tr>

    <% 
       idCounter++;
%>