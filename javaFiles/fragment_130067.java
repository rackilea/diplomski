public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException, ServletException {

    HttpSession session = request.getSession();
    session.getAttribute("cart");
    //...
    session.setAttribute("cart", whateverYouWant);