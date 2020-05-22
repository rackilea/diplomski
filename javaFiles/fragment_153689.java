protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try
    {
        response.setContentType("text/html");
        String name = request.getParameter("name") ;
        PrintWriter out = response.getWriter();
        out.println("<h1>Display name of your text area here: </h1>");
        //Here I want to have the text area content displayed.
        out.println(name);
        out.println();
        out.flush();
    }
    catch(Exception ex)
    {
        ex.printStackTrace();    
    }
    finally
    {
        out.close();
    }
}