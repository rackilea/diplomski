@WebServlet(name = "SampleServlet", urlPatterns = {"/sample"})
public class SampleServlet extends HttpServlet {

@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
   request.setAttribute("ID", "MyID");
   request.setAttribute("Name", "MyName");
   RequestDispatcher dispatcher = request
                       .getRequestDispatcher("/MangeNotifications.jsp");  
   if (dispatcher != null){  
      dispatcher.forward(request, response);  
   }
  }
}