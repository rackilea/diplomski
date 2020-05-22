INSERT INTO refuel (id_tank, time, fuel_volume, refueling_speed) 
 SELECT ?, ?, ?, ? 
 FROM refuel
 WHERE NOT EXISTS (SELECT 
                   FROM refuel 
                   WHERE
                       id_tank = ? 
                   AND time = ? 
                   AND fuel_volume = ?
                   AND refueling_speed = ?);