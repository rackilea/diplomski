<%

 String data=" Science Plants,Animals,Humans,Nature";//your data from db

 String [] values=data.split(",");

%>

<select>
 <%
   for(int i=0;i<values.length;i++)
   {
 %>

  <option><%=values[i]%></option>

 <%
 }
 %>

</select>