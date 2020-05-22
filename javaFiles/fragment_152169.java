while(rs.next())
{
    flag = 1;
    if(rs.getInt("id")!=-1)     
       {
        <tr><td align="center"><%=rs.getInt("id")%></td> 
        <td align="center"><%=rs.getString("name")%></td>
        <td align="center"><%=rs.getInt("salary")%> </td>
        <td align="center"><%=rs.getString("Designation") %></td>
       }
}   
if ( flag == 0 )
     out.println("Table is empty");