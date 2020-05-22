<%
    String recordToDelete = request.getParameter("deleteid");

    // Use PreparedStatements here instead of Statment
    rs = stmt.executeQuery("delete from Postdata where primary_key_id="+ recordToDelete );

     response.sendRedirect("JSP1.jsp"); // redirect to JSP one, which will again reload.
%>