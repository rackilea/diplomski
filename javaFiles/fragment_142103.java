SUCCESS CONSTANT BINARY_INTEGER := 1;
FAILURE CONSTANT BINARY_INTEGER := 0;

SUBTYPE error_code_type  IS BINARY_INTEGER;
SUBTYPE error_message_type IS VARCHAR2(1000);

PROCEDURE
  raise_error_if_failure
  (
    status        BINARY_INTEGER,
    error_code    ERROR_CODE_TYPE,
    error_message ERROR_MESSAGE_TYPE
  )
  IS
BEGIN
  IF status = FAILURE THEN
    raise_application_error(error_code, error_message);
  END IF;
END;


FUNCTION
  do_something_in_java
  (
    arg1          VARCHAR2,
    arg2          VARCHAR2,
    error_code    OUT ERROR_CODE_TYPE,
    error_message OUT ERROR_MESSAGE_TYPE
  )
  RETURN BINARY_INTEGER
    AS LANGUAGE JAVA
    NAME 'mypackage.MyClass.doSomething(java.lang.String, java.lang.String, int[], java.lang.String[]) return int';


PROCEDURE
  do_something
  (
    arg1 VARCHAR2,
    arg2 VARCHAR2
  )
IS
  error_code    ERROR_CODE_TYPE;
  error_message ERROR_MESSAGE_TYPE;
BEGIN
  raise_error_if_failure(
      do_something_in_java(arg1, arg2, error_code, error_message),
      error_code,
      error_message
    );
END;