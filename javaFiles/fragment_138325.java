CREATE or REPLACE 
PROCEDURE TEST( 
   activationStartDate IN DATE, 
   activationEndDate IN DATE, 
   deActivationStartDate IN DATE, 
   deActivationEndDate IN DATE ) 
AS 
   CURSOR main_cur
   IS
      WITH include_rec 
        AS (SELECT first_name, 
                   start_date,
                   COUNT(1) OVER (PARTITION BY first_name) name_count
              FROM Employee 
             WHERE start_date BETWEEN activationStartDate 
                                  AND activationEndDate)
      SELECT DISTINCT 
             first_name
        FROM include_rec
       WHERE start_date NOT BETWEEN deActivationStartDate 
                                AND deActivationEndDate
         AND name_count > 2; 
   --
   FirstNameListTable dbms_sql.varchar2_table;    
BEGIN    
    OPEN main_cur;
    FETCH main_cur BULK COLLECT INTO FirstNameListTable;
    CLOSE main_cur;

    FOR i IN FirstNameListTable.FIRST .. FirstNameListTable.LAST 
    LOOP                 
           ---business logic         
    END LOOP; 

    etc...