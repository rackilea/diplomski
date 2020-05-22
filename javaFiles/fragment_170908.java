@WebServlet(urlPatterns = "/vController")
public class vlController extends HttpServlet {    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String host = request.getHeader("Host");
        System.out.println("Host: "+host);
        resp.getWriter().write("host printed");
    }
}