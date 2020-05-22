protected void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws ServletException, IOException {

    String saludo="hi";  
    req.setAttribute("exito",saludo);
    req.getRequestDispatcher("MyPage.jsp").forward(req, resp);
}