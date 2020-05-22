protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
    PrintWriter writer = response.getWriter();
    writer.write("" + request.getLocalPort());
    writer.close();
}