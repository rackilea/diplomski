import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

response.setContentType("text/html");

String username = request.getParameter("username");
String password = request.getParameter("password");
PrintWriter pw = response.getWriter();
pw.print("Hello");
if (username.equals(password)) {
pw.println("<h1>Hello </h1>" + username);
}

}


}