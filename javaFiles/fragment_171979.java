CREATE OR REPLACE FUNCTION get_json(IN object_json text, OUT result text) 
RETURNS text AS $$
DECLARE
my_json json;
incr integer := 0;
json_array_size := 0;
return_value text;
BEGIN
        my_json := (SELECT cast(object_json AS json));
        while incr < json_size loop
          code_val := (SELECT my_json -> 'productos' ->incr->>'modelo');
        end loop;


        return result;
END;
$$ LANGUAGE plpgsql;