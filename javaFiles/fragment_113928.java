<%
    for (Category category : categories) {
%>
<tr>
    <td><%= category.getId() %>
    <input type="hidden" name="allIds" value="<%= category.getId() %>" /></td>
    <td><%= category.getName() %>
    </td>
    <td>
        <input type="submit" name="delete" value="Delete"/>
    </td>
</tr>
<%
    }
%>