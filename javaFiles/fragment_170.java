DECLARE
  l_blob BLOB;
BEGIN
  DBMS_LOB.createtemporary(l_blob, TRUE);
  test_create_excel('username', l_blob);
END;