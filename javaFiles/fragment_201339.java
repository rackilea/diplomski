public class ServletDatabaseConnect extends HttpServlet  
{
protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
    PrintWriter pw=res.getWriter();
    res.setContentType("text/html");        
    String tb=req.getParameter("table");    

    try
    {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","admin");
         Statement st=con.createStatement();
         System.out.println("connection established successfully...!!");     

         ResultSet rs=st.executeQuery("Select * from "+tb);


             while(rs.next())
             {
                 pw.println("<tr><td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td>"+
                                  "<td>"+rs.getString(3)+"</td></tr>");
             }
         pw.println("</table>");
         pw.close();
    }
    catch (Exception e){
        e.printStackTrace();
    }

}}