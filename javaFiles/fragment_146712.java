// Servlet
@SuppressWarnings("serial")
public class AjaxHandler extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException, ServletException {

        resp.setContentType("text/plain");
        resp.getWriter().print("Hello jQuery!");
    }
}

// View.jsp
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
<title>Insert title here</title>
</head>
<body>
    <script>    
        $(document).ready(function() {
            $.ajax({
                url : '/AjaxHandler', // servlet mapping ("web.xml")
                success : function(responseText) {
                    $('#ajaxHandlerResponse').text(responseText);
                }
            });
        });
    </script>
    Servlet's message: <span id="ajaxHandlerResponse"></span>
</body>
</html>