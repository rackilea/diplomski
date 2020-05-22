UPDATE mytbl SET field1 = $1, field2 = $2, ....;

IF NOT FOUND THEN

     INSERT INTO mytbl (field1, field2, ....) VALUES ($1, $2, ...);

END IF;