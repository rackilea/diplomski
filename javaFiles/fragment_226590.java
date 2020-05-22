WITH og AS (
  SELECT object_id,
         group_id
  FROM object_gitem
  JOIN group_gitem USING (gitem_id)
)
SELECT object_id
FROM object
WHERE object_id     IN (SELECT object_id
                        FROM og
                        WHERE group_id =  0)
  AND object_id NOT IN (SELECT object_id
                        FROM og
                        WHERE group_id <> 0);