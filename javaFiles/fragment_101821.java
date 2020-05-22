protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String loc = session.getAttribute("location").toString();
        System.out.println("location in ServletB from session is " + loc);

    }