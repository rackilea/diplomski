SELECT x.* 
  FROM my_table x 
  LEFT 
  JOIN my_table y 
    ON WEEK(y.date,3) = WEEK(x.date,3) 
   AND y.status NOT IN ('approved','pending') 
 WHERE y.id IS NULL;
Empty set (0.00 sec)