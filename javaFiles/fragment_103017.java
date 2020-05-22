SQL> purge recyclebin;

Recyclebin purged.

SQL> select * from tab;

TNAME                          TABTYPE  CLUSTERID
------------------------------ ------- ----------
BONUS                          TABLE
DEPT                           TABLE
EMP                            TABLE
SALGRADE                       TABLE

SQL> set serveroutput on;
SQL> begin
  2    for cur_r in (select tname from tab) loop
  3      dbms_output.put_line('spool ' || cur_r.tname ||'.txt');
  4      dbms_output.put_line('select * from ' || cur_r.tname ||';');
  5      dbms_output.put_line('spool off');
  6    end loop;
  7  end;
  8  /
spool BONUS.txt
select * from BONUS;
spool off
spool DEPT.txt
select * from DEPT;
spool off
spool EMP.txt
select * from EMP;
spool off
spool SALGRADE.txt
select * from SALGRADE;
spool off

PL/SQL procedure successfully completed.

SQL>