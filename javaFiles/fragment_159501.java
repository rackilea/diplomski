import java.sql.*;

 public class findl {

  public static void main(String[] args)
        {
            System.out.println("hi");
        }   
try{
    public Connection conn(){
        db dbs = new db();
        Connection clr = dbs.Connect();
        return clr;
            }
}


 catch(SQLException s){}