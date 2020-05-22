protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PrintWriter out = response.getWriter();
    out.println("<html>");
    out.println("<body>")
    out.println("<p>The date is: " + (new Java.util.date()).toLocaleString() +"</p>");
    out.println("</body>")
    out.println("</html>");
    out.close();
}