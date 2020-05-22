@SuppressWarnings("serial")
   @WebServlet(urlPatterns = { "*.ToDo" })
   public class UseGetRealPath extends HttpServlet {
    public void doGet( HttpServletRequest req, HttpServletResponse res )
      throws ServletException, IOException {
     String todoFile = getServletContext().getRealPath("/myText.txt");
     FileReader fr = new FileReader( todoFile );
     for( int c = fr.read(); c != -1; c = fr.read() ) {
      System.out.print( (char) c );
     }
     fr.close();
     res.getWriter().println( "check the console!" );
    }
   }