@WebServlet(urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String days = request.getParameter("Days");
        try (PrintWriter out = response.getWriter()) {
            out.println("<h1>Days value :  " + days + "</h1>");
        }
    }
}