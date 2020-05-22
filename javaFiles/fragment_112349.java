CREATE PROCEDURE updateXofY(
  in_id IN X.ID%TYPE,
  in_y  IN X.Y%TYPE
)
AS
  PRAGMA AUTONOMOUS_TRANSACTION;
BEGIN
  UPDATE X
  SET   Y  = in_y
  WHERE id = in_id;
  COMMIT;
END updateXofY;
/