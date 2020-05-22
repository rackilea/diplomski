import javax.servlet.*;
import javax.servlet.http.*;

public class UsersServlet extends HttpServlet {

    public void doGet (HttpServletRequest   req, HttpServletResponse  res)
        throws ServletException, IOException {

        res.setContentType("application/csv");
        PrintWriter w = res.getWriter();

        ArrayList<User> users = Users.getAllUsers();

        w.prinln(GenerateCsv.generateCsvFile(users));

        w.flush();
        w.close();
    }

    public void doPost (HttpServletRequest  req, HttpServletResponse  res)
        throws ServletException, IOException {
        ...
    }
}