@WebServlet(name = "test", urlPatterns = { "/testservlet" }) 
public class Test extends HttpServlet {
private static final long serialVersionUID = 1L;

public Test() {
    super();
}   

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
    String hobby = request.getParameter("hobby");   
    request.setAttribute("theHobby", hobby);
    request.getRequestDispatcher("hobbypage.jsp").forward(request, response);
}