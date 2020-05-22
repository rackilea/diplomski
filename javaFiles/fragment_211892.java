<% while(rs.next()){ %>

    <tr>
      <th>HDYK Stat</th><th>NUMBER</th>
     </tr>

    <tr class="<%=rs.getString("color") %>">
      <td><%=rs.getString("color") %></td><td><%= rs.getInt("Count")%></td>
    </tr>
<%      
} 
%>