CREATE OR REPLACE
 AND compile JAVA source named "Test0"
 AS
  import java.io.*;
   import java.sql.*;
 class Test0 {
     public static void Load(String dctry) throws SQLException {
     System.out.println(dctry);
     String qry = "CREATE OR REPLACE DIRECTORY IMG_DIR_TMP AS '" + dctry + "'";
      System.out.println(qry);
      #sql { 
            begin
              execute immediate :qry;
            end;
      };
    }
  }
/ 

CREATE OR REPLACE PROCEDURE test_0_sp(dctry IN VARCHAR2)
AS LANGUAGE JAVA
name 'Test0.Load(java.lang.String)';
/

begin
test_0_sp('/home/oracle/Desktop/sql/images');
end;