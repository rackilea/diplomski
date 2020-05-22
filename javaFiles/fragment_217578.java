<%@ page language="java" import="java.io.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.swing.JFileChooser" %>
<%@ page import="java.awt.Desktop"%>
<%@ page isErrorPage='true' %>
<%@ page import="java.text.SimpleDateFormat"%>
<%! 
    Connection conn = null;
    String url = "jdbc:mysql://localhost:3306/";
    String dbName = "su";
    String driver = "com.mysql.jdbc.Driver";
    String username = "root"; 
    String userPassword = "s";

%>



<%
    String filename="";
    response.setContentType("application/vnd.ms-excel");
    response.setHeader("Content-Disposition","inline;filename=" + "excel_sheet"+".xls");
    response.setHeader("Cache-Control","no-cache");
    PrintWriter pout = response.getWriter();
    String date1="";
    String time="";
try
{

        Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url+dbName,username,userPassword);
            Statement stmt = conn.createStatement();
        String strQuery = "select * from  Meter_List";
        ResultSet rs = stmt.executeQuery(strQuery);
        int index=3;
            int sno=0;
            String name="";
                pout.print("SNo\t");
                pout.print("MeterID\t"  );
                pout.print("ConsumerID\t" );
                pout.print("ConsumerName\t" );

                pout.println();
            while(rs.next()) 

                     {
                                int meterid = rs.getInt("Meterid");
                        int consumerid=rs.getInt("Consumerid");
                        String consumername = rs.getString("Consumername");

                                sno++;
                        pout.print(sno + "\t");
                        pout.print(meterid + "\t" );
                        pout.print(consumerid + "\t" );
                                pout.print(consumername + "\t");

                        index++;
                        pout.println();

                     }

} 
catch ( Exception ex ) 
{  
    //out.println("Error :: "+ex);
    out.println("");
} 
%>