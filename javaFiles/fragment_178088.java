public class YourServlet extends HttpServlet{

        public void doGet(HttpServletRequest request, HttpServletResponse   
        response) throws IOException{
           String search = request.getParameter("search");
              if (search != null) {
                 request.setAttribute("search", search);
                RequestDispatcher rd =  
                  request.getRequestDispatcher("Content");
                rd.forward(request, response);
    }
        }
    }