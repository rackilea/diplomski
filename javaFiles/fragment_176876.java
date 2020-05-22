public class TestServlet extends javax.servlet.http.HttpServlet implements javax.servlet.Servlet {

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //business logic that deal with the your Model


        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
               rd.forward(request, response);
        }


}