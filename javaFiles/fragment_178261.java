create or replace function func
return number
as
begin
  dbms_lock.sleep(60);
  return 0;
end;
/

Function created.

SQL> set timing on
SQL> select func from dual;

      FUNC
----------
     0

Elapsed: 00:01:00.01