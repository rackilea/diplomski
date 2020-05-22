public class FrontServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext sc = this.getServletContext();
        if (someCondition) {
            sc.getRequestDispatcher("/jersey/servlet").forward(req, resp);
        }else{
            sc.getRequestDispatcher("/standard/router").forward(req, resp);
        }
    }
}