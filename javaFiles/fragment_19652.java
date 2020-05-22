<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="jvanamerongen.example.Subjects"%>
<%@page import="jvanamerongen.example.Subject"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <% Subjects list = new Subjects(); %>
        <select>
            <% for(Subject s : list.getAllFromSubject()) { %>
                <option value="<% out.print(s.getId()); %>"><% out.print(s.getSubjectAbbr()); %></option>
            <%}%>
        </select>
    </body>
</html>