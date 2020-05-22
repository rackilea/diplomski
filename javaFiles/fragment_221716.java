<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
</head>
<body>
<%
    Date d = new Date();
    SimpleDateFormat sp = new SimpleDateFormat("hh:mm:ss");
    String t= sp.format(d);
    out.print(t);
%>
</body>
</html>