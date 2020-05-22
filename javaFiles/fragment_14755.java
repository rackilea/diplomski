CREATE OR REPLACE FUNCTION get_java_property (prop IN VARCHAR2)
    RETURN VARCHAR2 IS
    LANGUAGE JAVA
    NAME 'java.lang.System.getProperty(java.lang.String) return java.lang.String' ;

DECLARE
  l_java_version   VARCHAR2 (240);
BEGIN
  l_java_version   := get_java_property ('java.version');
  DBMS_OUTPUT.put_line ('Java version is ' || l_java_version);
END;

--DROP FUNCTION get_java_property;