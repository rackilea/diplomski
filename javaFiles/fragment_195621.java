@WebServlet(urlPatterns = "/runtimeErrorHandler")
public class RuntimeErrorHandlerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html; charset=utf-8");
        try (PrintWriter writer = resp.getWriter()) {
            // Write your error handling page here...
        }
    }

}