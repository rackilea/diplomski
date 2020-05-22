<%List<String> data = (List<String>)request.getAttribute("InventoryData");
for(String s: data) { 
%>
<tr>
    <td>
        <%=s%>
    </td>