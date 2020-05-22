<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page session="true"%>
<%!String inp = null;
double temperature = 0;
double c = 0;
double f = 0;%>
<%
inp = request.getParameter("fTemp");    

if (inp == null || inp.equals("")) {
    response.sendRedirect("errorMsg.jsp?msg=You are missing values.");
    return;
}
try {
    if ("cel".equals(request.getParameter("temp"))) {
        f = Integer.parseInt(inp);
        c = (f - 32) * (5.0 / 9.0);
    } else {
        c = Integer.parseInt(inp);
        f = (c * (9.0 / 5.0)) + 32.0;

    }
} catch (Exception e) {
    response.sendRedirect("errorMsg.jsp?msg=Invalid numbers entered.");
    return;
}
 %>