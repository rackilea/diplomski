mysql>   INSERT INTO ticks (idticks, symbol, DATE, `time`, size, TYPE) VALUES (
    ->     1,
    ->     'EUR-USD',
    ->     STR_TO_DATE('10-04-2017', '%d-%m-%Y'),
    ->     STR_TO_DATE('11:21:21', '%h:%i:%s'),
    ->
    ->     1.656,
    ->     'askbid');
ERROR 1411 (HY000): Incorrect datetime value: '11:21:21' for function str_to_date
mysql> SHOW VARIABLES LIKE 'sql_mode';
+---------------+-------------------------------------------------------------------------------------------------------------------------------------------+
| Variable_name | Value                                                                                                                                     |
+---------------+-------------------------------------------------------------------------------------------------------------------------------------------+
| sql_mode      | ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION |
+---------------+-------------------------------------------------------------------------------------------------------------------------------------------+
1 row in set (0,02 sec)

mysql> SET sql_mode='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
Query OK, 0 rows affected, 1 warning (0,00 sec)

mysql> INSERT INTO ticks (idticks, symbol, DATE, `time`, size, TYPE) VALUES (     1,     'EUR-USD',      STR_TO_DATE('10-04-2017', '%d-%m-%Y'),      STR_TO_DATE('11:21:21', '%h:%i:%s'),           1.656,      'askbid');
Query OK, 1 row affected (0,00 sec)

mysql>