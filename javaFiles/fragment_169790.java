<%
    ArrayList<String> list1 = (ArrayList<String>)request.getAttribute("res1");
 %>
<select name="GName" >
    <%
        for(String list:list1)  
    { %>
    <option><%=list%></option>

   <% } 
    %>
</select>