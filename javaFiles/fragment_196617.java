SELECT id, capacity, gender
from (
SELECT t.id, t.gender, t.capacity,
       COUNT(*) AS rn
FROM t
   JOIN t AS t2
    ON  t2.gender = t.gender
   AND ( t2.capacity > t.capacity
          OR  t2.capacity = t.capacity
        AND t2.id <= t.id )
GROUP BY t.id, t.gender, t.capacity
HAVING COUNT(*) <= 2
ORDER BY t.capacity desc, rn ) tab
ORDER BY capacity desc 
LIMIT 3;

Result:
id  capacity    gender
1      10   M
2       9           M
5       7            F