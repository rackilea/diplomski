CREATE OR REPLACE FUNCTION updatesegment(segid bigint, segname text, segdesc text, segmeta text)
  RETURNS integer AS
$BODY$
  DECLARE
    rowsAffected integer := 0;
  BEGIN
    UPDATE segment
    SET
       name = segname,
       description = segdesc,
       segmentmetadata = segmeta
    WHERE
       id = segid;
    GET DIAGNOSTICS rowsAffected = ROW_COUNT; --here you get the affected rows
  END;
$BODY$
LANGUAGE plpgsql;