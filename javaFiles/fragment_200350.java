package de.so;

import java.io.IOException;
import java.io.Writer;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class ActionServlet extends HttpServlet
{

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) throws ServletException,
            IOException
    {
        String action = request.getParameter("action");
        Writer out=response.getWriter();

        if (action == null || action.isEmpty())
        {
            out.write("Action empty");
        }
        else if (action.equals("doThis"))
        {
            out.write("perform this Action");
        }
        else if (action.equals("doThat"))
        {
            out.write("perform that Action");
        }
    }
}