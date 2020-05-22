<%@page import="mysource.dbData"%>
<%
     searchParam = request.getParameter("searchStr");

     dbData data = new dbData();
     String result  = data.searchText(searchParam);
%>

<HTML>
  <BODY>
      The result is: <%  out.print(result); %>
  </BODY>
</HTML>