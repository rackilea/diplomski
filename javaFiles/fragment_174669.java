@WebServlet(name = "SampleServlet", urlPatterns = "/sampleServlet")
public class SampleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // called when an HTTP POST is sent
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // called when an HTTP GET is sent
    }
}