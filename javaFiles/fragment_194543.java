<%@page import="java.text.SimpleDateFormat, java.util.Calendar, java.text.DateFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
         <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <title>Date Tester</title>
     </head>
     <body>
         <%
             DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
             Calendar cal = Calendar.getInstance();           
         %>
        <form>
            <label for="date">Your Text Field: </label><br/>
            <textarea type="" name="date" value="" >Today's Date: <%=    dateFormat.format(cal.getTime()) + "\n" %></textarea>
        <!-- The rest of your form here -->
        </form>
    </body>
</html>