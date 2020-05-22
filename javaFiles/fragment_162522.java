import java.sql.*;
import java.lang.*;
import java.io.*;
import Com.ibm.db2.jcc.*;  //Type4 library
public class DB2Sample{
  static
  {
    try 
    {       

      Class.forName("com.ibm.db2.jcc.DB2Driver");
    } 
    catch (ClassNotFoundException e)
    {
       System.err.println("Could not load DB2 driver \n");
       System.err.println(e.getMessage());
       System.exit(1);
    }

public static void main(String args[]) 
  {

    /* Type 4 driver url */
    String url = "jdbc:db2j:net://machine-name:port-number/TGSAMPLE";
         Connection conn = DriverManager.getConnection(url,"userid", "psswrd");
...
  }