CREATE PROCEDURE add_data(
  in_value1      IN  YOUR_TABLE.VALUE1%TYPE,
  in_value2      IN  YOUR_TABLE.VALUE2%TYPE,
  in_other_value IN  OTHER_TABLE.VALUE%TYPE,
  out_id         OUT YOUR_TABLE.ID%TYPE,
  out_succcess   OUT VARCHAR2
)
IS
BEGIN
  INSERT INTO your_table ( id, value1, value2 )
  VALUES ( your_table_seq.NEXTVAL, in_value1, in_value2 )
  RETURNING id INTO out_id;

  INSERT INTO other_table( id, value )
  VALUES ( out_id, in_other_value );

  out_success := 'Ok'
EXCEPTION
  WHEN DUP_VAL_ON_INDEX THEN
    ROLLBACK;
    out_id      := NULL;
    out_success := 'Already exists!'; -- Handle exceptions
END;
/