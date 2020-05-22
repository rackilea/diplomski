public void doGet(HttpServletRequest req, HttpServletResponse response)
    throws ServletException, IOException {

    // set content type
    response.setContentType("text/html");

    // get response writer
    PrintWriter writer = response.getWriter();

    // build HTML code
    String htmlResponse = "<html>";
    htmlResponse += "<h2>This is my Response example:</h2>";    
    htmlResponse += "Some Text as an example.";
    htmlResponse += "</html>";

    // return response
    writer.println(htmlResponse);
}