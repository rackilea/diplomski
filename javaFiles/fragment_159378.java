CREATE OR REPLACE FUNCTION car_inst(_cname text, _loc text) 
  RETURNS TABLE (license_plate text) AS
$func$
   SELECT DISTINCT ci.license_plate
   FROM   carmodel    cm
   JOIN   carinstance ci USING (mid)
   WHERE  cm.category_name  = $1
   AND    ci.lname = $2
$func$ LANGUAGE sql;