CREATE OR REPLACE PROCEDURE get_data( p_start IN NUMBER
                                    , p_cur   OUT SYS_REFCURSOR)
IS
BEGIN

  OPEN p_cur FOR
    SELECT p_start a,'abc' b FROM dual
          UNION ALL
    SELECT p_start + 1,'cde' FROM dual
          UNION ALL
    SELECT p_start + 2,'xyz' FROM dual;

END;