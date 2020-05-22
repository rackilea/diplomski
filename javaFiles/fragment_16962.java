@WebServlet("/ExceptionHandler")
public class ExceptionHandler extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processException(request, response);
    }

    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processException(request, response);
    }
    private void processException(HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        Throwable throwable = (Throwable) request
                .getAttribute("javax.servlet.error.exception");
        // do whatever you want to do with exception        
        // forward request to error page
        request.getRequestDispatcher("/ErrorPage.jsp").forward(request, response);
    }
}