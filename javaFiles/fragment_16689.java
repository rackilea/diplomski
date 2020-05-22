IF EXISTS (SELECT 1 FROM mytbl WHERE id = $1 ) THEN

    EXECUTE 'UPDATE mytbl ...';

ELSE

    EXECUTE 'INSERT INTO mytbl ...';

END IF;