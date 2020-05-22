SQL> CREATE OR REPLACE AND COMPILE JAVA SOURCE NAMED "ArrayDemo"
  2  as
  3  
  4  import java.io.*;
  5  import java.sql.*;
  6  import oracle.sql.*;
  7  import oracle.jdbc.driver.*;
  8  
  9  public class ArrayDemo {
 10  
 11     public static void passArray() throws SQLException {
 12  
 13        Connection conn = new OracleDriver().defaultConnection();
 14  
 15        /*creation of NEW_ADDRS_OBJ*/
 16        StructDescriptor addrObjDescriptor =
 17           StructDescriptor.createDescriptor("NEW_ADDRS_OBJ",conn);
 18        Object[] addrAtributes = new Object[] {new String("address1"),
 19                                               new String("address2"),
 20                                               new String("city"),
 21                                               new String("state"),
 22                                               new Integer(12345)};
 23  
 24        /*creation of NEW_ADDRS_OBJ_ARRAY*/
 25        ArrayDescriptor addrTabDescriptor =
 26           ArrayDescriptor.createDescriptor( "NEW_ADDRS_OBJ_ARRAY", conn );
 27        STRUCT addr1 = new STRUCT(addrObjDescriptor,conn,addrAtributes);
 28        STRUCT[] adrStructArray = {addr1};
 29        ARRAY arrayAddr = new ARRAY(addrTabDescriptor,conn,adrStructArray);
 30  
 31        /*creation of ACCOUNT_OBJ*/
 32        StructDescriptor acctObjDescriptor =
 33           StructDescriptor.createDescriptor("ACCOUNT_OBJ",conn);
 34        Object[] acctAttributes = new Object[] {new String("AcctName"),
 35                                                arrayAddr};
 36  
 37        /*creation of ACCOUNT_OBJ_ARRAY*/
 38        ArrayDescriptor acctTabDescriptor =
 39           ArrayDescriptor.createDescriptor( "ACCOUNT_OBJ_ARRAY", conn );
 40        STRUCT acct1 = new STRUCT(acctObjDescriptor,conn,acctAttributes);
 41        STRUCT[] acctStructArray = {acct1};
 42        ARRAY acctArray = new ARRAY(acctTabDescriptor,conn,acctStructArray);
 43  
 44        /* statement */
 45        OraclePreparedStatement ps =
 46           (OraclePreparedStatement)conn.prepareStatement
 47              ("begin insert_new_address(:x); end;" );
 48  
 49        ps.setARRAY( 1, acctArray );
 50        ps.execute();
 51  
 52     }
 53  }
 54  /

Java created