CREATE OR REPLACE FUNCTION get_json(object_json json) 
RETURNS text AS $$
DECLARE

incr integer := 0;
json_array_size := 0;
result text := 'success';
BEGIN

        while incr < json_size loop
          code_val := (SELECT $1 -> 'productos' ->incr->>'modelo');
        end loop;


        return result;
END;
$$ LANGUAGE plpgsql;