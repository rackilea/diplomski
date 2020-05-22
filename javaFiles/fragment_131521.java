protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect(request.getContextPath() + "/folder.jsp");

        String folderid = request.getParameter("folderid");
        System.out.println("\n\nFolder id: " + folderid); // checking if folderid is fetchable or not
}