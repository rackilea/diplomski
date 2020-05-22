SELECT ... FROM (
    SELECT id FROM tbl
        WHERE lat BETWEEN... 
          AND lng BETWEEN... ) x
    JOIN tbl USING (id)
    WHERE ...;