cqlsh:test> CREATE TABLE test_times (a int, b timestamp, PRIMARY KEY (a,b));
cqlsh:test> INSERT INTO test_times (a,b) VALUES (1, toTimestamp(now()));
cqlsh:test> SELECT toUnixTimestamp(b) FROM test_times;

 system.tounixtimestamp(b)
---------------------------
         1513086032267

(1 rows)

cqlsh:test> SELECT b FROM test_times;

 b
---------------------------------
 2017-12-12 13:40:32.267000+0000

(1 rows)