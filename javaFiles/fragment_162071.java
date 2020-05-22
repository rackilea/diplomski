package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
        name = "OiServlet3",
        urlPatterns = {"/oi"},
        initParams = {
                @WebInitParam(name = "param1", value = "value1"),
                @WebInitParam(name = "param2", value = "value2")}
)
public class OiMundo extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        // escreve o texto
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Primeira Servlet</title>");
        out.println("</head>");
        out.println("<body>");
        ServletConfig config = getServletConfig();
        String parameter1 = config.getInitParameter("param1");
        out.println("Value of parameter 1: " + parameter1);
        String parameter2 = config.getInitParameter("param2");
        out.println("<br>Value of parameter 2: " + parameter2);
        out.println("<h1>Hi Servlet!</h1>");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }

}