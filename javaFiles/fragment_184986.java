package test.naishe.so;

public class HealthCheck extends HttpServlet {

    private static final long serialVersionUID = 940861886429788526L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        int response = HttpServletResponse.SC_INTERNAL_SERVER_ERROR;

        boolean checkServices = true;
        //optional: assumming you wanted to do health check on various services (eg. DB service) and have a utility class for that
        checkServices = CheckServices.checkAll();

        if(checkServices)
            response = HttpServletResponse.SC_OK;

        String out =
            "<healthCheck>" +
            "<services>" +
                (checkServices?"OK":"ERROR")
            "</services>" +
            "</healthCheck>"
            ;

        resp.setStatus(response);
        resp.getWriter().println(out);

    }
}