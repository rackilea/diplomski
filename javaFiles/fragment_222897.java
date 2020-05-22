protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  String name = "Jane"; //create a string
  request.setAttribute("name", name); //set it to the request

  RequestDispatcher rs = request.getRequestDispatcher("index.jsp"); //the page you want to send your value
  rs.forward(request,response); //forward it

}