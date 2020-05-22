@WebServlet(name = "TestServlet", urlPatterns = {"/test"})
public class TestServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       double value=((double)(new GregorianCalendar(2013, 0, 1).getTimeInMillis() - new GregorianCalendar().getTimeInMillis()))/1000;
       PrintWriter pw=response.getWriter();
       response.setContentType("text/plain");
       pw.print(value);
       pw.flush();
    }
}