following is my servlet code now

package servlet.package1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;




@WebServlet("/ServletTalk")
public class ServletTalk extends HttpServlet {
    private static final long serialVersionUID = 1L;


    public ServletTalk() {
        super();
        // TODO Auto-generated constructor stub


    }

 // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        JSONObject json = new JSONObject();


        //ObjectOutputStream out = new ObjectOutputStream(response.getOutputStream());
        Enumeration paramNames = request.getParameterNames();

        String[] params = new String[2];
        int i = 0;
        while (paramNames.hasMoreElements()) {
            String paramName = (String) paramNames.nextElement();


            //System.out.println(paramName);
            String[] paramValues = request.getParameterValues(paramName);
            params[i] = paramValues[0];

            //System.out.println(params[i]);
            i++;

        }

        String sql = "SELECT LOGIN_ID, PASSWORD FROM SE_USER where LOGIN_ID=? and PASSWORD=?";
        Connection con = getConnection();

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, params[0]);
            ps.setString(2, params[1]);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                json.put("info", "success");
                /*String sql1 = "SELECT uname, password FROM users";
                PreparedStatement ps2=con.prepareStatement(sql1);
                ResultSet rs2=ps2.executeQuery();
                JSONArray arrayJSON=new JSONArray();
                while(rs2.next())
                {
                    JSONObject arrayObject = new JSONObject();
                    arrayObject.put("userName", rs2.getString("uname"));
                    arrayObject.put("passWord", rs2.getString("password"));
                    arrayJSON.add(arrayObject);
                }


                json.put("IDS",arrayJSON);*/
            } else {
                json.put("info", "fail");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(json);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        //json.put("info", disp);
        response.getWriter().write(json.toString());
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public static Connection getConnection() {
    Connection con = null;
    try {
        Class.forName("com.mysql.jdbc.Driver");//Mysql Connection
        //Class.forName("oracle.jdbc.driver.OracleDriver");//Oracle Connection
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(ServletTalk.class.getName()).log(Level.SEVERE, null, ex);
    }
    try {
        con = DriverManager.getConnection("jdbc:mysql://localhost:8889/a9613246_mydata1", "root", "root");//mysql database
        //con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hemabh_demo", "hemabh_demo");//oracle database

    } catch (SQLException ex) {
        Logger.getLogger(ServletTalk.class.getName()).log(Level.SEVERE, null, ex);
    }
    return con;
}



}