<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <script type="text/javascript" src="js/jquery-1.11.2.js"></script>
    <script type="text/javascript">
        var auto_refresh = setInterval(
                function () {
                    $('#load_me').load('date.jsp').fadeIn("slow");
                }, 3000); 
    </script>
</head>
<body>
<div id="load_me">
<%@ include file="date.jsp"%>
</div>
</body>
</html>