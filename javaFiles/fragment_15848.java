SQL> CREATE OR REPLACE
  2  PROCEDURE show_java_calling_plsql
  3  AS LANGUAGE JAVA
  4  NAME 'ArrayDemo.passArray()';
  5  /

Procedure created

SQL> exec show_java_calling_plsql

AcctName, address1, address2, city, state, 12345

PL/SQL procedure successfully completed