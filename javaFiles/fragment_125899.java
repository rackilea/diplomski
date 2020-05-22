protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        String selectedItem = request.getParameter("selectedValue");


        productList = connDB.getProduct(query);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            if(selectedItem == (Your Condition)){
                   out.println("<option >1</option>");
                   out.println("<option >2</option>");
                   out.println("<option >3</option>");
                   out.println("<option >4</option>");
            }else{}


        } finally {            
            out.close();
        }
    }