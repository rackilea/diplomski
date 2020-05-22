SPOOL diff.txt
SELECT * FROM flatfile_table
MINUS
SELECT * FROM db_table
UNION
SELECT * FROM db_table
MINUS
SELECT * FROM flatfile_table
ORDER BY SortCriteria;
SPOOL OFF