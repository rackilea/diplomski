CREATE OR REPLACE FUNCTION get_excel_blob(p_username VARCHAR2) RETURN BLOB
AS
  l_blob BLOB;
BEGIN
  DBMS_LOB.createtemporary(l_blob, TRUE);
  test_create_excel(p_username, l_blob);
  RETURN l_blob;
END;