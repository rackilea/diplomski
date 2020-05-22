protected void processRequest(HttpServletRequest request, HttpServletResponse response)
  throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    String str = "<b>heloo</b>";
    request.setAttribute("result", str);
    request.getRequestDispatcher("/index.jsp").forward(request, response);
}