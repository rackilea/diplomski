<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:userpage userName="${user.fullName}">
  <p>
    First Name: ${user.firstName} <br/>
    Last Name: ${user.lastName} <br/>
    Phone: ${user.phone}<br/>
  </p>
</t:userpage>