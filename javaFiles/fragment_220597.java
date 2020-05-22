protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    PrintWriter printWriter = response.getWriter();
    JSONArray arrayObj=new JSONArray();

    TimeTableDAO timeTable = new TimeTableDAO();
    ArrayList<String[]> data = timeTable.getTimeTableData();

    for (int i = 0; i < data.size(); i++){
        for (int j = 0; j < data.get(i).length; j++){
            arrayObj.put(data.get(i)[j]); // instead of writing directly, add it to the JSONArray.
        }
    }
    printWriter.println(arrayObj.toString()); //write the JSONArray to the response
    response.sendRedirect("script.js");
    //response.getWriter().write(data.toString()); //this doesn't do what you want


}