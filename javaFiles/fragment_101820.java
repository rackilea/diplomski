protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String loc = request.getSession().getAttribute("location").toString();
        System.out.println("location in ServletA from session is " + loc);

        RequestDispatcher rd = request.getRequestDispatcher("geco.jsp");
        rd.forward(request, response);
    }