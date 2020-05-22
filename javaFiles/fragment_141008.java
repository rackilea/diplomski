DECLARE
  batchSize NUMBER(4,0) := 2500;
  numRows   NUMBER(8,0) := 1000000;
BEGIN
  FOR i IN 1 .. numRows LOOP
    INSERT INTO randomValues
    SELECT rnd
    FROM   (
      SELECT DISTINCT
             FLOOR(
               DBMS_RANDOM.VALUE(
                 POWER( 10, 10 ),
                 POWER( 10, 11 )
               )
             ) AS rnd
      FROM   DUAL
      CONNECT BY ROWNUM <= batchSize * 1.1
    ) r
    WHERE ROWNUM <= batchSize
    AND   NOT EXISTS ( SELECT 'X'
                       FROM   randomValues e
                       WHERE  e.rnd = r.rnd );
  END LOOP;
END;
/