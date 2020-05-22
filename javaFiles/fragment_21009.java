import java.io.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LicenseServlet extends HttpServlet {

public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        out.print("<html><body><table>");

        // ... pseudocode
        while (resultSet.next()) { 
            out.print("<tr><td>");
            out.print("%8s   %-50s   %-7s%n",resultSet.getString("cymer_id"), resultSet.getString("name"), resultSet.getString("license"));   
            out.print("</td></tr>");

        } 


        out.print("</table></body></html>");
  }
}