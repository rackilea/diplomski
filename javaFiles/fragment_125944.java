<%  request.getSession();
    String ses=(String) session.getAttribute("usr");
    if (session != null && !session.isNew()) {

    } else if(!session.equals(ses))
            {
        response.sendRedirect("loginPage.jsp");
    }
%>