public abstract class BoxletServlet extends HttpServlet {

  protected void doGet(HttpServletRequest request, HttpServletResponse response) 
    throws ServletException, IOException {

    HttpSession session = request.getSession(true);
    String s = request.getParameter("source");

    // based on 's' choose from the available DataSource
    List<DataSource> sources = (List<DataSource>) session.getParameter("availableSources");
    Source source = chooseFrom(sources, s);                                                       
    session.setParameter("currentSource", source);          

    // forward to a page saying that the DataSource changed

  }