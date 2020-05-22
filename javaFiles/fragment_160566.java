public class HelloServlet extends HttpServlet {

   @Override

   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
   {
        PrintWriter writer = resp.getWriter();

        writer.println("<p>Hello World!</p>");