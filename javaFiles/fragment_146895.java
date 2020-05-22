<%@ page import="org.apache.struts.Globals" %>
<%@ page import="org.apache.struts.taglib.html.Constants" %>
<html>
    <head>
      <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
      <title>Insert title here</title>
    </head>
    <body>
      <form name="employee" action="EmployeeSubmit.do" method="POST">
        <input type="hidden" name="<%= Constants.TOKEN_KEY %>" value="<%= session.getAttribute(Globals.TRANSACTION_TOKEN_KEY) %>">
        <TABLE>
          <TR>
            <TD>Name</TD>
            <TD>
              <input type="text" name="empName">
            </TD>
          </TR>
          <TR>
            <TD>ID</TD>
            <TD>
              <input type="text" name="empId">
            </TD>
          </TR>
          <TR>
            <TD colspan="2">
              <input type="submit" value="Submit">
            </TD>
          </TR>
        </TABLE>
      </form>
    </body>
</html>