protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
   String s = new String("A String");
 String json = new Gson().toJson(s);
 this.response.setContentType("application/json");
 this.response.setCharacterEncoding("UTF-8");
 Writer writer = null;
 try {
        writer = this.response.getWriter();
        writer.write(json);
 } finally {
    try {
        writer.close();
    } 
    catch (IOException ex) {
    }
 }
}