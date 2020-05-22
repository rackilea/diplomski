DROP TABLE IF EXISTS my_table;

CREATE TABLE my_table
(id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,string VARCHAR(30) NOT NULL);


INSERT INTO my_table (string) VALUES
('BOM 9W BDQ 3285 9W BOM 3285 INR6570END XT 380WO113'),
('AMD EK X/DXB EK MUC 1241.36CWE1SIN1/LNE3 EK X/DXB'),
('BDQ 9W MAA 6300 INR6300END');

DROP TABLE IF EXISTS ints;

CREATE TABLE ints(i INT NOT NULL AUTO_INCREMENT PRIMARY KEY);
INSERT INTO ints VALUES (0),(1),(2),(3),(4),(5),(6),(7),(8),(9);

SELECT b.*
  FROM 
     ( SELECT id,SUBSTRING_INDEX(SUBSTRING_INDEX(string,' ',i+1),' ',-1) x, MIN(i) rank FROM my_table JOIN ints GROUP BY id,x ORDER BY id,rank 
     ) a
  JOIN
     ( SELECT id,SUBSTRING_INDEX(SUBSTRING_INDEX(string,' ',i+1),' ',-1) x, MIN(i) rank FROM my_table JOIN ints GROUP BY id,x ORDER BY id,rank 
     ) b
    ON b.id = a.id
   AND b.rank = a.rank -1
 WHERE a.x REGEXP '^[0-9]{4}';

+----+-----+------+
| id | x   | rank |
+----+-----+------+
|  1 | BDQ |    2 |
|  2 | MUC |    4 |
|  3 | MAA |    2 |
+----+-----+------+