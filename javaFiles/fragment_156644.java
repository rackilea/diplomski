<%--
  Created by IntelliJ IDEA.
  User: pwwpche
  Date: 2014/4/21
  Time: 14:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <title></title>
    <script type="text/javascript" src="bootstrap/js/jquery.min.js"></script>
    <script type="text/javascript">
        function submit(){
            var msgContent = document.getElementById("txtMessage").value;
            $.ajax({
                url: "myServlet",
                data: {
                    text : msgContent
                },
                success: function (data) {
                    alert(data);
                },
                error: function (data) {
                    console.log(data);
                }
            });
        }
    </script>
</head>
<body>
<form action="myServlet">
    <input type="text" name="mytext" id="mytext">
    <input type="submit" onclick="submit()">
</form>
</body>
</html>