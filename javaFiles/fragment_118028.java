public class Login extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response){

        HttpSession session = request.getSession();
        String user = (String)request.getParameter("userName");
        session.setAttribute("userName", user);

        request.getRequestDispatcher("/homepage.jsp").forward(request, response);
    }
  }