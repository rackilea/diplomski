SELECT
    CONCAT('ALTER TABLE ',db,'.',tb,' RENAME ',db,'.',LOWER(tb),';')
FROM
    (SELECT table_schema db,table_name tb
     FROM information_schema.tables WHERE
     table_schema in (YOUR_DATABASE_NAME)
    ) A;