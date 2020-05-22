protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    System.out.println("Get Response");
    response.setContentType("application/json");
    ConvertCSV cleanup = new ConvertCSV();
    String outputData = cleanup.cleanupData(response.getWriter());
    ...