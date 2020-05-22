SELECT * FROM (
  SELECT * FROM _12603 UNION ALL 
  SELECT * FROM _25912 UNION ALL 
  SELECT * FROM _44057 UNION ALL 
  SELECT * FROM _76468
) 
WHERE 
REPLACE(path, rtrim(path, replace(path, '\', '')), '') -- only filename
LIKE '%e%' GROUP BY path;