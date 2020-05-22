CREATE OR REPLACE FUNCTION car_inst(_cname text, _loc text) 
  RETURNS TABLE (license_plate text) AS
$func$
   SELECT DISTINCT ci.license_plate
   FROM   carmodel    cm
   JOIN   carinstance ci USING (mid)
   JOIN   reservation r1 ON r1.category_name = cm.category_name
   JOIN   reservation r2 ON r2.lname = ci.lname
   WHERE  r1.rid = $1
   AND    r2.rid = $2;
$func$ LANGUAGE sql;