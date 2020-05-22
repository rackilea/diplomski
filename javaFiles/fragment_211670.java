protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       HttpSession session = request.getSession(true);
        session.setAttribute("name", "MyName");
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }