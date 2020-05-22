SELECT
     CASE
          WHEN EXISTS (
               SELECT 1
               FROM tablename
               WHERE match_id = 'xxxx'
          ) THEN 1                  --exists
          ELSE 0                    --does not exists
     END
FROM dual;