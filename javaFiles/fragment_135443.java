@WebServlet(name = "requests", description = "Requests: Trivial request", urlPatterns = "/requests")
public class RequestsServlet extends HttpServlet {
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    req.getHeader("X-Cloud-Trace-Context")
  }
}