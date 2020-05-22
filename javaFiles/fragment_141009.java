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
  CONNECT BY ROWNUM <= :numRows * 1.1
) r
WHERE ROWNUM <= :numRows
AND   NOT EXISTS ( SELECT 'X'
                   FROM   randomValues e
                   WHERE  e.rnd = r.rnd );