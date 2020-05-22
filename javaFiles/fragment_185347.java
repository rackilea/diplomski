DROP FUNCTION sf.start_mc(integer);

CREATE FUNCTION sf.start_mc(thefirst integer) RETURNS void AS $$
BEGIN
    EXECUTE format('CREATE SEQUENCE sf.mastercase START %s',thefirst);
END;

$$ LANGUAGE plpgsql;