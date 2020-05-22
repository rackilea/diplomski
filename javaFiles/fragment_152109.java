public class SharedSQL extends HttpServlet{

    doGet(request ,response){
         request.setAttribute("sqlstmt", "select ABC from ABC");
    }
}