import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/** Copyright (c), AnkitMittal JavaMadeSoEasy.com */
public class PreparedStatementDeleteExample {
    public static void main(String... arg) {
           Connection con = null;
           PreparedStatement prepStmt = null;
           try {
                  // registering Oracle driver class
                  Class.forName("oracle.jdbc.driver.OracleDriver");

                  // getting connection
                  con = DriverManager.getConnection(
                               "jdbc:oracle:thin:@localhost:1521:orcl",
                               "ankit", "Oracle123");
                  System.out.println("Connection established successfully!");             

                  con.setAutoCommit(false); //Now, transactions won't be committed automatically.

                  prepStmt = con.prepareStatement("DELETE from EMPLOYEE where ID=? ");

                  //1) add set of parameters in PreparedStatement's object - BATCH of commands
                  prepStmt.setInt(1, 7); //substitute first occurrence of ? with 7
                  prepStmt.addBatch();

                  //2) add set of parameters in PreparedStatement's object - BATCH of commands                  
                  prepStmt.setInt(1, 8); //substitute first occurrence of ? with 8
                  prepStmt.addBatch();


                  //Execute PreparedStatement batch
                  prepStmt.executeBatch();
                  System.out.println("PreparedStatement Batch executed, DELETE done");

                  con.commit(); //commit all the transactions

           } catch (ClassNotFoundException e) {
                  e.printStackTrace();
           } catch (SQLException e) {
                  e.printStackTrace();
           }
           finally{
                  try {
                        if(prepStmt!=null) prepStmt.close(); //close PreparedStatement
                        if(con!=null) con.close(); // close connection
                  } catch (SQLException e) {
                        e.printStackTrace();
                  }
           }
    }
}