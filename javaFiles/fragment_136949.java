SELECT
  object_name, 
  object_type, 
  status, 
  timestamp
FROM 
  user_objects
WHERE 
  (object_name NOT LIKE 'SYS_%' AND 
   object_name NOT LIKE 'CREATE$%' AND 
   object_name NOT LIKE 'JAVA$%' AND 
   object_name NOT LIKE 'LOADLOB%') AND
  object_type LIKE 'JAVA %'
ORDER BY
  object_type, 
  object_name;