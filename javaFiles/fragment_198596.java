[snikolaev@dev01 ~]$ mysql -P9314 -h0
Welcome to the MySQL monitor.  Commands end with ; or \g.
Your MySQL connection id is 1
Server version: 2.6.3 5bc9e81@180316 dev

Copyright (c) 2009-2017 Percona LLC and/or its affiliates
Copyright (c) 2000, 2017, Oracle and/or its affiliates. All rights reserved.

Oracle is a registered trademark of Oracle Corporation and/or its
affiliates. Other names may be trademarks of their respective
owners.

Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.

mysql> select *, geodist(48.712002, 2.677411, latitude, longitude) dist from idx_min where match('desc*') and dist < 20 and ANY(post_category_id) in (1);
+------+-----------+-----------+------------------+-----------+
| id   | latitude  | longitude | post_category_id | dist      |
+------+-----------+-----------+------------------+-----------+
|    1 | 48.712002 |  2.677410 | 1,2              | 11.099242 |
+------+-----------+-----------+------------------+-----------+
1 row in set (0.00 sec)