@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    System.out.println("ok" + clickerModel.getRecentAnswer());
    request.setAttribute("clickerModel", clickerModel);
    request.getRequestDispatcher("results.jsp").forward(request, response);
}