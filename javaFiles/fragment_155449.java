CREATE OR REPLACE TYPE str_table
    IS TABLE OF varchar2(100);

CREATE OR REPLACE PROCEDURE process_checkboxes( p_checkboxes IN str_table )
AS
BEGIN
  FOR i IN 1 .. p_checkboxes.count
  LOOP
    <<do something with p_checkboxes(i)>>
  END LOOP;
END;