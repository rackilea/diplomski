<ul>
<%
for(Integer key : yourmap.keySet()) {
    String value = data.get(key);
    System.out.printf("%s = %s%n", key, value);

    %>
    <li><%= value%></li>
    <%
}
%>
</ul>