public class HelloServlet extends HttpServlet {
       private static final long serialVersionUID = 1L;

public HelloServlet() {
    super();
}

protected void doGet(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {

    String user = request.getParameter("name");
    String password = request.getParameter("Password");

    PACKAGENAME.User.setUser(user);
    PACKAGENAME.User.setPassword(password);
    request.setAttribute("log", user);
    request.setAttribute("pass", password);
    boolean result = PACKAGENAME.User.Auth(user, password);
    System.out.println(result);

    if(result == true) {
        RequestDispatcher rd = request.getRequestDispatcher("Welcome.jsp");
        rd.forward(request, response);
        System.out.println();
    } else {
        System.out.println();
        response.sendRedirect("Hello.jsp");
       }
}

protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
    }
}