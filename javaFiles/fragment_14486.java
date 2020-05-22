CREATE OR REPLACE AND RESOLVE JAVA SOURCE NAMED "CreateCLOB"
AS 
import java.sql.*;
import oracle.sql.*;
import oracle.jdbc.*;

/****** START PASTE JAVA CLASS HERE *****/
public class CreateCLOB{

  public static void ClobProc (Clob cl[]) throws SQLException
  {
    Connection conn = DriverManager.getConnection ("jdbc:default:connection:"); /* or use "jdbc:oracle:kprb:" */

    Clob clob =  CLOB.createTemporary(conn, false, oracle.sql.CLOB.DURATION_SESSION); /* this is deprecated in 12c */
                // conn.createClob(); /* works fine in 12.1.0.2.0 */
    clob.setString(1, "Test Data");
    cl[0] = clob;
  }
}
/