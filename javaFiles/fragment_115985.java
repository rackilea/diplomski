<%if(rs2.next()){%>
<%
topic=rs2.getString(1);
%>
<%}%>   

      <tr class="tablePlainWhite" style='vertical-align:top'>
<td><input type="checkbox" value="<%=rs1.getString(1)%>" <%if((rs1.getString(1).equals(topic))){%> CHECKED name="top" <%}else{%> name="topic" <%rs2.previous();%> <%}%>></td>
<td><%=rs1.getString(1)%></td>
</tr>
 <%}%>