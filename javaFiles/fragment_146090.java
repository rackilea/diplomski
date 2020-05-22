public void doGet(HttpServletRequest req, HttpServletResponse resp) 
  throws IOException {
    request.setAttribute("myvalue",val);
    RequestDispatcher rd = sc.getRequestDispatcher("mypage.jsp");
    rd.forward(req, res);
 }