HttpSession session = request.getSession(false);
 String employeeid="";

            if(session != null) { 
                employeeid = (String)session.getAttribute("employeeid"); 
            }