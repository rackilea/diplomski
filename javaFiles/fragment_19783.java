try {

    List<Customer> customers = cvq.list(name);
    request.setAttribute("customers", customers); 
    request.getRequestDispatcher("CustomerProfile.jsp").forward(request, response);

     } catch (SQLException e) {
    throw new ServletException("Cannot obtain vehicles from DB", e);
     }
}