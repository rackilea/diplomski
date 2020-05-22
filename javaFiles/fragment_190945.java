SQL> create table test (end_dt timestamp);

Table created.

SQL> insert into test values (systimestamp);

1 row created.

SQL> select * From test where end_dt < sysdate;

END_DT
----------------------------------------------------
02.02.19 20:42:08,375000

SQL>