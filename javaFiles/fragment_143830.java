SELECT count(*)
FROM table1 x1
WHERE EXISTS(
  SELECT 1 FROM table1 x2
  WHERE x1.`username` = x2.`relation`
    AND x1.`relation` = x2.`username`
)
AND x1.`username` ='user1';