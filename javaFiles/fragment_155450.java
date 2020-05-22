import java.io.*;
import java.sql.*;
import oracle.sql.*;
import oracle.jdbc.driver.*;

public class ArrayDemo
{
   public static void passArray() throws SQLException
   {
       Connection conn = <<get your JDBC connection>>

       String checkboxStr = "checkbox1=IC&checkbox2=S";
       String strArray[] = checkboxStr.split("&");

       ArrayDescriptor descriptor =
         ArrayDescriptor.createDescriptor( "STR_TABLE", conn );

       ARRAY array_to_pass =
          new ARRAY( descriptor, conn, strArray);

       OraclePreparedStatement ps =
           (OraclePreparedStatement)conn.prepareStatement
           ( "begin process_checkboxes(:x); end;" );

       ps.setARRAY( 1, array_to_pass );

       ps.execute();   
   }
}