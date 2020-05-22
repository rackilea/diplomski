SELECT max(t1.count_by_id), m.name, FROM (  
   SELECT id, cast(date as date) as cdate, count(*) as count_by_id
   FROM entrance    
   GROUP BY cdate, id) as t1 
INNER JOIN man m ON (t1.id = m.id) 
GROUP BY t1.id;