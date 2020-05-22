@WebServlet(name = "Log", urlPatterns = { "/log" }) 
public class LogServlet extends HttpServlet { 
  private static final long serialVersionUID = 7503953988166684851L; 

  public LogServlet() { 
    super(); 
  } 

  @Override 
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
      throws ServletException, IOException { 
    Path path = FileSystems.getDefault()
          .getPath("/path/to/tomcat/logs", "catalina.out"); 
    StringBuilder logContent = new StringBuilder(); 
    logContent.append("<pre>"); 
    try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8);) { 
        String line = null; 
        while ((line = reader.readLine()) != null) { 
            logContent.append(line).append("<br/>"); 
        } 
    } catch (IOException x) { 
        // Take care of that 
    } 
    logContent.append("</pre>"); 
    resp.getWriter().print(logContent.toString()); 
  } 

  @Override 
  public void init(ServletConfig servletConfig) throws ServletException { 
    super.init(servletConfig); 
  } 
}