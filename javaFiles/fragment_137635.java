public class AddUserServlet extends HttpServlet {

    private DBJoint db;

    @Override
    void init(ServletConfig config) {
        ServletContext servletContext = config.getServletContext();
        db = servletContext.getAttribute("db");
    }

    ...

}