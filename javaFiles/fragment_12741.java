public class HelloWorld extends HttpServlet
{
    private static final long serialVersionUID = -1L;
    ProcessData processData;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
   {
        // Set response content type
        response.setContentType("text/html");

        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        out.println("<h1>" + ProcessData.getStatus() + "</h1>");
    }
}