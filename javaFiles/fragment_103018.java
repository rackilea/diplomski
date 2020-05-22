SQL> set pagesize 100
SQL> set linesize 100
SQL> spool BONUS.txt
SQL> select * from BONUS;

ENAME      JOB              SAL       COMM
---------- --------- ---------- ----------
KING       PRESIDENT       1000        100

SQL> spool off
SQL> spool DEPT.txt
SQL> select * from DEPT;

    DEPTNO DNAME          LOC
---------- -------------- -------------
        10 ACCOUNTING     NEW YORK
        20 RESEARCH       DALLAS
        30 SALES          CHICAGO
        40 OPERATIONS     BOSTON

SQL> spool off
SQL> spool EMP.txt
SQL> select * from EMP;

     EMPNO ENAME      JOB              MGR HIREDATE        SAL       COMM     DEPTNO
---------- ---------- --------- ---------- -------- ---------- ---------- ----------
      7369 SMITH      CLERK           7902 17.12.80        800                    20
      7499 ALLEN      SALESMAN        7698 20.02.81       1600        300         30
      7521 WARD       SALESMAN        7698 22.02.81       1250        500         30
      7566 JONES      MANAGER         7839 02.04.81       2975                    20
      7654 MARTIN     SALESMAN        7698 28.09.81       1250       1400         30
      7698 BLAKE      MANAGER         7839 01.05.81       2850                    30
      7782 CLARK      MANAGER         7839 09.06.81       2450                    10
      7839 KING       PRESIDENT            17.11.81       5000                    10
      7844 TURNER     SALESMAN        7698 08.09.81       1500          0         30
      7900 JAMES      CLERK           7698 03.12.81        950                    30
      7902 FORD       ANALYST         7566 03.12.81       3000                    20
      7934 MILLER     CLERK           7782 23.01.82       1300                    10

12 rows selected.

SQL> spool off
SQL> spool SALGRADE.txt
SQL> select * from SALGRADE;

     GRADE      LOSAL      HISAL
---------- ---------- ----------
         1        700       1200
         2       1201       1400
         3       1401       2000
         4       2001       3000
         5       3001       9999

SQL> spool off
SQL>