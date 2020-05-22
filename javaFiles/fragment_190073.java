<form action="item" method="get">
<table>
<%
ItemManager mgr = new ItemManager();
Item[] items = mgr.getAllItems();
for(int i = 0; i < items.length; i++){
%>

<tr>
     <td>
            <%=items[i].getItemName()%>
            <input type="text" name="itemID" value="<%=items[i].getItemId()%>">
            <input type="submit" value="View"> </td></tr>

<%
}
%></table>
</form>