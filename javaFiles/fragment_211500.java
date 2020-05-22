CREATE TABLE strings (s VARCHAR(4000));

CREATE TYPE t_varchar2_array AS TABLE OF VARCHAR2(4000);
/

CREATE OR REPLACE PROCEDURE p_array_test(
    p_strings      t_varchar2_array
)
AS
BEGIN
  FOR i IN 1..p_strings.COUNT
  LOOP
    INSERT INTO strings (s) VALUES (p_strings(i));
  END LOOP;
END;
/