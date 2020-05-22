protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    // then just use that to get it through a GET Http Method
    String id = request.getParameter("id");
    HttpSession session = request.getSession();
    ArrayList<Float> list = (ArrayList<Float>) session.getAttribute("list");
    response.getWriter().append("item:  ").append(String.valueOf(list.get(0)));
}