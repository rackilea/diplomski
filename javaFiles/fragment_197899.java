<%@tag description="User Page template" pageEncoding="UTF-8"%>
<%@tag import="com.example.User" %>
<%@attribute name="user" required="true" type="com.example.User"%>

First Name: ${user.firstName} <br/>
Last Name: ${user.lastName} <br/>
Phone: ${user.phone}<br/>