public class "servletName" extends HttpServlet{

   private Vector<Object> vector = new Vector<Object>();

    public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
     {
     vector.add(request.getParameter("UID"));
     } 
    }