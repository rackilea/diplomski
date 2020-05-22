<% String s = request.getParameter("search"); %>
    <%=s %>
    <% if (s==null || s.isEmpty()) { %> 
     <div>textbox is empty</div>

   <% } else { %>
   <div>textbox value..
    <% } %>