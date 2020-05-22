CREATE OR REPLACE PROCEDURE insertChildAndParentDetails(
    p_schoolID IN childTable.SCHOOL_ID%TYPE,
    p_studentName IN parentTable.STUDENTNAME%TYPE,
    p_parentName IN childTable.PARENTNAME%TYPE,
    p_emailId IN childTable.EMAILID%TYPE)
IS
BEGIN

  INSERT INTO childTable ("SCHOOL_ID", "PARENTNAME", "EMAILID") 
  VALUES (p_schoolID, p_parentName,p_emailId);

  INSERT INTO parentTable ("STUDENTNAME") 
  VALUES (p_studentName)

  COMMIT;

END;
/