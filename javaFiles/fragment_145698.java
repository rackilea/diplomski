SQL> DECLARE
  2     c   INTEGER := DBMS_SQL.open_cursor ();
  3  BEGIN
  4     DBMS_SQL.parse (c, 'select * form dual', DBMS_SQL.native);
  5
  6     DBMS_SQL.close_cursor (c);
  7  EXCEPTION
  8     WHEN OTHERS THEN
  9        DBMS_OUTPUT.put_line ('Last Error: ' || DBMS_SQL.LAST_ERROR_POSITION ());
 10        DBMS_SQL.close_cursor (c);
 11        RAISE;
 12  END;
 13  /
Last Error: 9
DECLARE
*
ERROR at line 1:
ORA-00923: FROM keyword not found where expected
ORA-06512: at line 11