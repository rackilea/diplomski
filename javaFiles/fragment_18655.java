<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<t:base>

    <jsp:attribute name="js">
        <p>hi</p>
    </jsp:attribute>
    <jsp:attribute name="nav">
        <jsp:include page="nav.jsp" />
    </jsp:attribute>
    <jsp:body>
        <p>hi</p>
    </jsp:body>
</t:base>