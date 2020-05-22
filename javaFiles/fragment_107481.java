<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript" src="js/jquery-1.9.0.min.js"></script>
<script type="text/javascript" src="js/jquery.fileDownload.js"></script>
<script>
    $(document).on("submit", "form.fileDownloadForm", function(e) {

        $.fileDownload($(this).prop('action'), {
            successCallback : function(url) {
                $('form#nextPage').submit();
            },
            failCallback : function(responseHtml, url) {
                alert('File download failed!!!!');
            }
        });

        e.preventDefault();
    });
</script>
</head>
<body>
    First
    <form action="<%=request.getContextPath()%>/img" method="get"
        class="fileDownloadForm" id="imgForm">
        <input type="submit" value="Download Image">
    </form>
    <form action="<%=request.getContextPath()%>/test" method="get"
        id="nextPage"></form>
</body>
</html>