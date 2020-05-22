public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Login() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                      //right your code here to get data from jstlClass and pass it to the jsp in request
      request.setAttribute("","");
            request.getRequestDispatcher("/FirstJSP.jsp").forward(request, response);                
        } 

protected void doget(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        }       
        }
    }
}