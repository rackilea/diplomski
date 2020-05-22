@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      //in this case we are going to use this doGet method to handle your ajax response and when you initially load your data so we need to check if it's ajax or not, we can do that with this:
   boolean ajax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));

        try {

            List<Product> products = productDAO.list();
            request.setAttribute("products", products); 



     if (ajax) {
    //where the magic happens
   //Returning List<Entity> as JSON
    String json = new Gson().toJson(products);
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write(json);
    }else{
    //not an ajax request so process normally
    request.getRequestDispatcher("/products.jsp").forward(request, response);
    }

        } catch (SQLException e) {
            throw new ServletException("Cannot obtain products from DB", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {
  //your form submits your new product to here, where you will save in your database
        try {
            Product p = new Product();
            p.setName(requset.getParameter("pname"));
            p.setDescription(requset.getParameter("pdesc"));
            p.setPrice(new BigDecimal(requset.getParameter("price")));

            productDAO.Save(p);
            //if (productDAO.Save(p) > 0) {
               //response.getWriter().write(String.valueOf("sucess"));
            //} else {
                //response.getWriter().write(String.valueOf("saved fail"));
            //}
        } catch (Exception e) {
            e.printStackTrace();
            //response.getWriter().write(String.valueOf(e));
        }

    doGet(request,response); //forward request and response to doGet method
}