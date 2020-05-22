<%
        do {
    %>  
    <tr>
        <td><%=request.getParameter("PONo") %></td>
        <td><%=rs.getString(1) %></td>
        <td><%=rs.getInt(3)%></td>
        <td><%=request.getParameter("ReceivedQty")%></td>
        <td><%=rs.getInt(4) %></td>
        <td><%=request.getParameter("ReceivedDate")%></td>
    </tr>
     <%
        } while (rs.next());
    %>