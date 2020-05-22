@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String answer = request.getParameter("answer");
        clickerModel.addAnswer(answer);

        request.setAttribute("recentAnswer", clickerModel.getRecentAnswer());
        //request.getRequestDispatcher("submit.jsp").forward(request, response);  
    response.sendRedirect("getResults"); //   <---After submit will go to this page. 
    }