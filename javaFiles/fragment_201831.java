Connection conn = null;

try{
     Class.forName("com.mysql.jdbc.Driver");
 conn =DriverManager.getConnection
 ("jdbc:mysql://localhost:3306/userpass","root", "root"); //removed after userpass
     if(conn!=null)
     out.println("connected to database successfully");
     else
     out.println("not connected to database");

  }catch(Exception e)
  {
   out.println(e);
 }