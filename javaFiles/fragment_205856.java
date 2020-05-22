package start;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Start
 */
@WebServlet("/Start")
public class Start extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Start() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse respond) throws ServletException, IOException {
        PrintWriter pw = respond.getWriter();
        respond.setContentType("text/html");
        String tb = request.getParameter("table");
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc::oracle::thin:@localhost:music", "root", "1234");
            Statement st = con.createStatement();
            System.out.println("connection established successfully!");
            ResultSet rs = st.executeQuery("SELECT * FROM" + tb);

            pw.println("<table border=1>");
            while (rs.next()) {
                pw.println("<tr><td>" + rs.getInt(1) + "</td></td>+rs.getString(2)+</td>" + "<td>" + rs.getString(3)
                        + "</td></tr>");
            }
            pw.println("</table>");
            pw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // TODO Auto-generated method stub
        // response.getWriter().append("Served at:
        // ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }
}