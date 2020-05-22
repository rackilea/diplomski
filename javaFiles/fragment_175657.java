CREATE TABLE tableName (myDate DECIMAL(8));

SELECT myDate DIV 10000 AS year,
       ELT((myDate DIV 100) MOD 100, "Jan", "Feb", …) AS month,
       myDate MOD 100 AS day_of_month
FROM tableName
WHERE myDate BETWEN 20121021 AND 20121023;