import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class HelloWorld extends HttpServlet { 
  protected void doGet(HttpServletRequest request, 
      HttpServletResponse response) throws ServletException, IOException 
  {
    String color= request.getParameter("color");   
      // HERE CALL A METHOD TO STORE DATA IN DATABASE exp insertInDB(color);

    request.setAttribute("mycolor", color);// if you want to see your data
     request.getRequestDispatcher("test.jsp").forward(request, response);

  }  
}