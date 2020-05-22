DECLARE RESULT INTEGER;

SET OutputRoot.XMLNSC.employees=null;

DECLARE outputref REFERENCE TO OutputRoot.XMLNSC.employees;

CALL retrieveData(CAST(AGE AS INTEGER),outputref) into RESULT;