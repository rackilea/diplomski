@WebServlet("/ServletCode")
  public class ServletCode extends HttpServlet {
  private static final long serialVersionUID = 1L;

    public ServletCode() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            String output= request.getParameter("username");
            System.out.println(output);
             PrintWriter pw = response.getWriter();
             pw.println("Hello " + output);
        }
}