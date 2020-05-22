import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/LearningServlet")
public class LearningServlet extends HttpServlet {
private static final long serialVersionUID = 1L;
public LearningServlet() {
    super();
}
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
}
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String age=request.getParameter("age");
    String gender=request.getParameter("gender");
    String schoolname=request.getParameter("schoolName");
    String work=request.getParameter("work");
    String home=request.getParameter("home");

    response.setContentType(getServletContext().getMimeType("text/html"));
    PrintWriter pw=response.getWriter();
    pw.write("<html><body>");
    pw.write("Age           :"+age+"<br>");
    pw.write("Gender        :"+gender+"<br>");
    pw.write("School Name   :"+schoolname+"<br>");
    pw.write("Work          :"+work+"<br>");
    pw.write("Home          :"+home+"<br>");
    pw.write("</body></html>");
   }
}