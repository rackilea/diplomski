public abstract class BaseServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // wrap it in try-catch if you need to
        prePerformLogic(req, resp);
        // call super implementation for delegation to appropriate handler
        super.service(req, resp);
    }

    protected abstract void prePerformLogic(HttpServletRequest req,
            HttpServletResponse resp) throws ServletException, IOException;
}