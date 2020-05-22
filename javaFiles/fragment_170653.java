import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

@WebServlet ( "/now" )
public class NowServlet extends HttpServlet {

    public void doGet ( HttpServletRequest req , HttpServletResponse res )
        throws ServletException, IOException {

        res.setContentType( "text/plain" );
        PrintWriter out = res.getWriter();

        Instant instant = Instant.now();
        String output = instant.toString();

        out.println( output );
    }
}