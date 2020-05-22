<%@page import="com.epam.mvc3.helpers.Utils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<c:forEach items="${model}" var="item">
   <!-- The following line defines the type of the item variable -->
   <jsp:useBean id="item" type="com.ACME.mvc3.model.Topic"/>
   <tr>
       <!-- The following line doesn't need curly braces -->          
       <td height="20"><p><%=Utils.actionLink(item.getName(), "topic", "details") %></p></td>
   </tr>
</c:forEach>