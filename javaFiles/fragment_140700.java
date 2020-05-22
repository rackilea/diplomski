SELECT vehicle_id, 
       SUM(CASE WHEN type_id = 1 THEN amount ELSE 0 END) AS Diesel,
       SUM(CASE WHEN type_id = 2 THEN amount ELSE 0 END) AS Insurance,
       SUM(CASE WHEN type_id = 3 THEN amount ELSE 0 END) AS Tyre,
       SUM(CASE WHEN type_id = 4 THEN amount ELSE 0 END) AS Battery,
       SUM(CASE WHEN type_id = 5 THEN amount ELSE 0 END) AS Oil,
       SUM(CASE WHEN type_id = 6 THEN amount ELSE 0 END) AS Garage
FROM expenses 
GROUP BY vehicle_id;