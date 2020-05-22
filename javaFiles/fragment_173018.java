/**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // TODO Auto-generated method stub
            String value = value; //JSON value you want to return
            StringBuilder out = new StringBuilder();
            out.append("{\"key\": \"" + value+ "\"}");
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().write(out.toString());
    }