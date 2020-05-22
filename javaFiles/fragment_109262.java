if(list!=null && 
      list.get(0).getFieldValue("userName").equals(uname) 
      && list.get(0).getFieldValue("password").equals(pword)){
        HttpSession  session=request.getSession(true);
        session.setAttribute("userName", uname);
        session.setAttribute("password", pword);
        response.getWriter().append("Login SucessFully");
        response.sendRedirect("admin.jsp");
    } else {
        response.sendRedirect("index.jsp");
    }