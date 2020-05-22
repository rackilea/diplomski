create or replace FUNCTION FUNC_GetMessages (
    OperatorList IN VARCHAR2
)   
RETURN T_MSGTABLE AS
  vMsg_List       T_MSGTABLE;
BEGIN 

... some code here
...
....

    SELECT T_MSGTABLE( message) 
    BULK COLLECT INTO vMsg_List
    FROM 
    (  
        SELECT MESSAGE FROM MESSAGETABLE WHERE OPERATOR IN 
          (SELECT to_number(column_value) as opId FROM xmltable(OperatorList));
    );
END;