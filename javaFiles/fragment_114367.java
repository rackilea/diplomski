$result= mysql_query("
  Select * FROM (
    Select * FROM user 
    WHERE
      latitude > $minLat 
      AND latitude < $maxLat 
      AND longitude > $minLon 
      AND longitude < $maxLon 

      -- Surround $date2 with quotes
      AND post_date > '$date2'
    ORDER BY post_date DESC LIMIT $amount1) a
  ORDER BY post_id");