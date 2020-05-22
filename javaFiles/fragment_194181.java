<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<c:set var="isEvents" value="${fn:contains(pageContext.request.requestURI, '/events/')}" />
<c:set var="isPeople" value="${fn:contains(pageContext.request.requestURI, '/people/')}" />

<html>
<head>
  <title>My Events - <decorator:title /></title>
  <base href="${pageContext.request.contextPath}">
  <link href="assets/styles.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="tabs">
  <a ${isEvents ? 'class="selected"' : ''} href="events/Listing.action">Events</a>
  <a ${isPeople ? 'class="selected"' : ''} href="people/Listing.action">People</a>
</div>

<div class="submenu">
  <c:if test="${isEvents}">
    <a href="Listing.action">List of Events</a>|<a href="New.action">New Event</a>
  </c:if>
  <c:if test="${isPeople}">
    <a href="Listing.action">List of People</a>|<a href="New.action">New Person</a>
  </c:if>
  &nbsp;
</div>