public void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException
{
    String userName=request.getParameter("userName");
    String newUrl = "ServletB";
    response.addHeader("REMOTE_USER", userName);
    RequestDispatcher view = request.getRequestDispatcher(newUrl);
    view.forward(request, response);
}