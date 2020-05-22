@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private FirstEJB firstEJB;

    @EJB
    private SecondEJB secondEJB;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println(firstEJB.helloFirst());
        out.println(secondEJB.helloSecond());   
    }
}