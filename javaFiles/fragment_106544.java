<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
    <html>
    <body>
        <div id="tabs" style="background-color: #C8C8C8; font-family: fantasy;">
            <a href="employee">&nbsp; Employee Details </a>
            <a href="department"> Departments </a>
            <a href="designation"> Designation </a>
            <a href="logout"> Logout </a>
            <c:if test=${sessionScope.user.isAdmin}>
            <a href="user"> Users </a>
            <a href="roles"> Roles </a>
            </c:if>
        </div>
    </body>
    </html>