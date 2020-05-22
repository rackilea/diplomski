<%@page contentType="text/html" pageEncoding="UTF-8"%>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <html> 
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>Login Form</title>
<link rel="stylesheet" href="application.css" type="text/css">
</head>
<body>
<div align="center">
    <div class="header"></div>
    <div class="mainbody">

        <H4>Please answer the following quetions</H4>
        <form method="post" action="demoServlet">
            <table cellspacing="5" cellpadding="5">
                <tr>
                    <td>${quentionAnsers[1]}</td>
                </tr>
                <tr>
                        <c:choose>
                            <c:when test="${quentionAnsers[0] == 'single'}">
                                <input type="checkbox" name="language" value="English" />English
                                <input type="checkbox" name="language" value="French" />French
                            </c:when>
                            <c:otherwise>
                                <input type="radio" name="gender" value="Male" />Male
                                <input type="radio" name="gender" value="Female" />Female</td>
                        </c:otherwise>
                    </c:choose>
                    </td>

                </tr>

            </table>
            <br />
            <br />
  <input type="submit" value="Submit" />
        </form>
         </div>
       </div>
       </body>
        </html>