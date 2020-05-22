SQL>     CREATE OR REPLACE FUNCTION returnTrue
  2      RETURN VARCHAR2
  3      AS LANGUAGE JAVA
  4      NAME 'example.returnTrue() return java.lang.String';
  5  /


Function created

SQL> select returntrue from dual;

RETURNTRUE
--------------------------------------------------------------------------------
TRUE