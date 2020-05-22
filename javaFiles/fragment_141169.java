DROP TABLE IF EXISTS my_table;

CREATE TABLE my_table
(ID INT NOT NULL AUTO_INCREMENT PRIMARY KEY
,Status VARCHAR(20) NOT NULL
,ProjId INT NOT NULL
,ActId INT NOT NULL
,Date DATE NOT NULL
);

INSERT INTO my_table VALUES
(1  ,'pending',1     ,1     ,'2014-08-07'),
(2  ,'denied',   1     ,2     ,'2014-08-08'),
(3  ,'saved',    1     ,3     ,'2014-08-09'),
(4  ,'approved', 1     ,4     ,'2014-08-10');

SELECT *,WEEK(date) FROM my_table;
+----+----------+--------+-------+------------+------------+
| ID | Status   | ProjId | ActId | Date       | WEEK(date) |
+----+----------+--------+-------+------------+------------+
|  1 | pending  |      1 |     1 | 2014-08-07 |         31 |
|  2 | denied   |      1 |     2 | 2014-08-08 |         31 |
|  3 | saved    |      1 |     3 | 2014-08-09 |         31 |
|  4 | approved |      1 |     4 | 2014-08-10 |         32 |
+----+----------+--------+-------+------------+------------+

SELECT x.* 
  FROM my_table x 
  LEFT 
  JOIN my_table y 
    ON WEEK(y.date) = WEEK(x.date) 
   AND y.status NOT IN ('approved','pending') 
 WHERE y.id IS NULL;
+----+----------+--------+-------+------------+
| ID | Status   | ProjId | ActId | Date       |
+----+----------+--------+-------+------------+
|  4 | approved |      1 |     4 | 2014-08-10 |
+----+----------+--------+-------+------------+