SQL> SET SERVEROUTPUT ON
SQL> CALL dbms_java.set_output(2000);

Call completed.

SQL> 
SQL> CREATE OR REPLACE AND COMPILE JAVA SOURCE NAMED "MyOutput" as
  2  
  3  import java.lang.*;
  4  public class MyOutput {
  5  
  6      public static String print(String testString) {
  7        System.out.println(testString); // want this output into ORACLE console
  8        return testString;
  9      }
 10  }
 11  /

Java Source MyOutput created

SQL> 
SQL> create or replace procedure Test_Output(testString in varchar2)
  2  as LANGUAGE JAVA
  3  NAME 'MyOutput.print(java.lang.String)';
  4  /

Procedure TEST_OUTPUT compiled

SQL> 
SQL> exec Test_Output('Hello');
Hello


PL/SQL procedure successfully completed.

SQL>