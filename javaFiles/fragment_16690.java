EXECUTE 'UPDATE mytbl ...';

GET DIAGNOSTICS reccount = ROW_COUNT;

IF reccount = 0 THEN

     EXECUTE 'INSERT INTO mytbl ...';

END IF;