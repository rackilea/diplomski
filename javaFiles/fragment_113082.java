protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
        List<Product> products = productService.list(); // Obtain all products.
        request.setAttribute("products", products); // Store products in request scope.
        request.getRequestDispatcher("/WEB-INF/products.jsp").forward(request, response); // Forward to JSP page to display them in a HTML table.
    } catch (SQLException e) {
        throw new ServletException("Retrieving products failed!", e);
    }
}