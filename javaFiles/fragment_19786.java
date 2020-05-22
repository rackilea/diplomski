protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

String name = request.getParameter("name");
CustomerViewQuery cvq = new CustomerViewQuery();

 try {
   //not list required this time, created a new method called 'getCustomer'
    Customer customer = cvq.getCustomer(name);
    request.setAttribute("customer", customer); 
    request.getRequestDispatcher("CustomerProfile.jsp").forward(request, response);

     } catch (SQLException e) {
    throw new ServletException("Cannot obtain vehicles from DB", e);
     }
}