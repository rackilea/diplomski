public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    PrintWriter writer        = response.getWriter();
    List<MyObject> objectList = service.getListFromDataBase();
    String jsonList           = new Gson().toJson(objectList);
    response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    writer.write(jsonList);
}