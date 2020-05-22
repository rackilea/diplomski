<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script src="//code.jquery.com/jquery-1.10.2.js"></script>
<script type="text/javascript">
 function func()
 {
     var arr=[2,3,3];
     var form = $('<form action="Test" method="get">' +
             '<input type="hidden" name="id" value="'+arr+'">' +
             '</form>');
     alert( $(form));
             $(form).submit();
 }
</script>
<body>
    <button onclick="func()">Deepak</button>
</body>
</html>