SELECT *
FROM time_frames
WHERE current_timestamp BETWEEN
            (CAST (current_date || ' ' || start
                  AS timestamp without time zone
            ) AT TIME ZONE time_zone)
         AND
            (CAST (current_date || ' ' || "end"
                  AS timestamp without time zone
           ) AT TIME ZONE time_zone)
  AND extract(dow FROM current_date) = day_of_week;