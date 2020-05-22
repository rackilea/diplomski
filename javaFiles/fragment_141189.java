<%@page import="com.my.package.DateRenderer"%>
[...]

<div id="somediv">
    <script language="Javascript">
        <%
        String dayDate = DateRenderer.getDayDate();
        %>
        document.write('<%=dayDate%>');
    </script>
</div>