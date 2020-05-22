// With @WebServlet annotation the webapp/WEB-INF/web.xml is no longer required.
@WebServlet(name = "requests", description = "Requests: Trivial request", urlPatterns = "/requests")
public class RequestsServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    resp.setContentType("text/plain");
    resp.getWriter().println("Hello, world");
  }
}