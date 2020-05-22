SELECT CAST(
         TO_TIMESTAMP_TZ(
           'Thu Nov 24 15:20:52 CET 2016',
           'DY MON DD HH24:MI:SS TZR YYYY'
         )
         AT TIME ZONE 'UTC'
         AS DATE
       )
FROM   DUAL;