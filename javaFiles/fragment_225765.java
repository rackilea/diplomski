public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException {

        Integer param = null;
        try {
            param = Integer.parseInt(req.getParameter("param"));
        }
        catch(NumberFormatException e) {
        }
    }
}