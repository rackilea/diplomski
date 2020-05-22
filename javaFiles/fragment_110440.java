protected void doGet(HttpServletRequest request, 
  HttpServletResponse response) throws ServletException, IOException {

   RequestDispatcher view;
   //not sure where are you getting your item from. DB??
   request.setAttribute("item", item);
   view = request.getRequestDispatcher("/home/editexpense.jsp");
   view.forward(request,response);
}