<%
      rs = stmt.executeQuery("select primary_key_id, title from Postdata");
%>
  <table id="rounded-corner" summary="all posts">

     <tbody>
        <% while (rs.next()) {
             String primaryKey = rs.getString(1);
        %>
         <tr>
             <td>
                <%=rs.getString(2)%>
             </td>
             <td>

                 <a href ="JSP2.jsp?deleteid=<%=primaryKey%>">Delete</a>
              </td>
          </tr>
          <%}%>

        </tbody>
     </table>