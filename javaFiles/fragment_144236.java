private void sendCustomerList(HttpServletResponse response, HttpServletRequest request)//redirect to index
        throws IOException, ServletException {
    String url = "/index.jsp";
    request.setAttribute("customers", customers);
    request.getRequestDispatcher(url).forward(request,response);
}