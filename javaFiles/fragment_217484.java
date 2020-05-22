CREATE OR REPLACE FUNCTION ins_upd_func() RETURNS trigger AS $BODY$
BEGIN
  -- Remember who changed the payroll when
  IF TG_OP = 'INSERT' THEN
    NEW.created_ts := current_timestamp;
  ELSE
    NEW.updated_ts := current_timestamp;
  END IF;
  RETURN NEW;
END; $BODY$ LANGUAGE plpgsql VOLATILE;