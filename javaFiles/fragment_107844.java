create or replace type stringArray is table of varchar2(4000);
/
CREATE OR REPLACE AND COMPILE JAVA SOURCE NAMED Parser AS
import java.sql.Connection;
import oracle.jdbc.OracleDriver;
import oracle.jdbc.OracleConnection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Array;

public class Parser {

    public static Array parseToArray(String str, String delim) throws SQLException {
        OracleDriver ora = new oracle.jdbc.OracleDriver();
        Connection conn = ora.defaultConnection();
        OracleConnection oraConn = (OracleConnection)conn;
        Array arr = oraConn.createARRAY("STRINGARRAY", str.split(delim));
        return arr;
    }
}
/
CREATE OR REPLACE FUNCTION
PARSETOARRAY (str IN VARCHAR2, delim IN VARCHAR2) 
RETURN STRINGARRAY AS
LANGUAGE JAVA NAME 'Parser.parseToArray (java.lang.String, java.lang.String) return java.sql.Array';
/
DECLARE
v_array STRINGARRAY;
BEGIN
  FOR testing IN (SELECT record FROM interfacelog) LOOP
    v_array := PARSETOARRAY(testing.record, '|'); 
  END LOOP;
END;