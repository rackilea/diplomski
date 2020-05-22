protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    doGet(request, response); //if form action chosen
}

// if using doGet() / href option
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();

        //you can implement switch case here if having more possible actions/links on the page
        if(action.equals("/list")){
            List<empGetSet> empdetails = employeeDAO.getAllEmp(); //or call employeeService layer which calls employeDAO
            request.setAttribute("empdetails", empdetails);
            RequestDispatcher dispatcher = request.getRequestDispatcher("Employees.jsp");
            dispatcher.forward(request, response);
        }
}