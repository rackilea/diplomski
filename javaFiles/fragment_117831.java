protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    request.setCharacterEncoding("UTF-8");
    String b = request.getParameter("Problem");
   // String a = request.getParameter("message");

    StringBuffer text = new StringBuffer(request.getParameter("message"));

    int loc = (new String(text)).indexOf('\n');
    while(loc > 0){
        text.replace(loc, loc+1, "<BR>");
        loc = (new String(text)).indexOf('\n');
   }

    request.setAttribute("message", text);
    request.setAttribute("problem", b);
    request.getRequestDispatcher("./index.jsp").forward(request, response);
}