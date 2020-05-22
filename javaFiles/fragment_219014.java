int USER_ID = 1;
    int ANSWER_ID = 1;  
    chat.setANSWER(request.getParameter("answer"));
    chat.setUSER_ID(USER_ID);
    chat.setANSWER_ID(ANSWER_ID);

    chat = dao.add(chat);
    USER_ID++;
    ANSWER_ID++;
    String answer=   request.getParameter("answer");
    request.setAttribute("answer", answer);
    RequestDispatcher rd=req.getRequestDispatcher("/ChatBot.jsp");
    rd.forward(req, resp);