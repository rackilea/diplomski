CREATE OR REPLACE FUNCTION month_traffic(hostcode int) RETURNS numeric(14,2) AS $$
DECLARE
  begin_date date := CAST((EXTRACT(year FROM now()) || '-' || EXTRACT(month FROM now()) || '-' || '01') AS date);
  end_date date := CAST((EXTRACT(year FROM now()) || '-' || EXTRACT(month FROM now()) + 1 || '-' || '01') AS date);
  result numeric(14,2) := 0;
BEGIN
  result := (SELECT SUM(day_mbytes) FROM daily 
    WHERE (day_hstcode = hostcode) AND (day_date >= begin_date) AND (day_date < end_date));
  IF (result IS NULL) THEN
    result := 0;
  END IF;
  RETURN result;
END;
$$ LANGUAGE plpgsql