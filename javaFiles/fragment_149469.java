class LogServlet extends HttpServlet
{
   @Override
   protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
   {
      File logFile = new File(System.getProperty("catalina.base"), "logs/catalina.log");
      String contents = FileUtils.readFileToString(logFile);
      PrintWriter out = new PrintWriter(resp.getOutputStream());
      out.println(contents);
   }
}