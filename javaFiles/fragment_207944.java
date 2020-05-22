import java.sql.*;
class ChangeRootPassword
{
        public static void main(String[] args) 
        {
                try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "example");
                        String sql = "SET PASSWORD FOR 'root'@'localhost' = PASSWORD('test')";
                        Statement stmt = conn.createStatement();
                        stmt.executeQuery(sql);
                        stmt.close();
                        conn.close();
                        System.out.println("Password is changed successfully!");
                        }
                catch(Exception ex){
                        ex.printStackTrace();
                        }
        }
}