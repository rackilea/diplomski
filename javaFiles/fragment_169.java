DECLARE
  l_blob BLOB;
BEGIN
  l_blob := getBlobWrp('test');

  dbms_output.put_line(UTL_RAW.CAST_TO_VARCHAR2(l_blob));
END;