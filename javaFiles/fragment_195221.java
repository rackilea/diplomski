<%
   String resultFile = saveFile.replaceAll(".arf", ".wmv");
%>

<html>
   <body>
      Your file successfully converted<br />
      Click <a href="downloadservlet.jsp?f=<%= resultFile %>">here</a> to download<br />
  </body>