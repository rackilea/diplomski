import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;


public class Servlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
    throws IOException
    {
        String text = request.getParameter("text");  //Retrieve data
        PrintWriter out = response.getWriter();
        out.println("Hello, you've typed" + text);
    }
}