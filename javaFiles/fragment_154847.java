>sqlplus / as sysdba

SQL*Plus: Release 11.2.0.3.0 Production on Mon Dec 16 08:48:42 2019

Copyright (c) 1982, 2011, Oracle.  All rights reserved.


Connected to:
Oracle Database 11g Release 11.2.0.3.0 - 64bit Production

SQL> show parameter processes

NAME                                 TYPE        VALUE
------------------------------------ ----------- ------------------------------
aq_tm_processes                      integer     1
db_writer_processes                  integer     1
gcs_server_processes                 integer     0
global_txn_processes                 integer     1
job_queue_processes                  integer     1000
log_archive_max_processes            integer     4
processes                            integer     150
SQL> alter system set processes = 500 scope = spfile;

System altered.