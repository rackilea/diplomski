mysql> desc cars;
+--------------+---------------------+------+-----+---------+----------------+
| Field        | Type                | Null | Key | Default | Extra          |
+--------------+---------------------+------+-----+---------+----------------+
| car_id       | bigint(20) unsigned | NO   | PRI | NULL    | auto_increment |
| manufacturer | varchar(100)        | YES  |     | NULL    |                |
+--------------+---------------------+------+-----+---------+----------------+
2 rows in set (0.03 sec)

mysql> desc bookings;
+------------+---------------------+------+-----+---------+----------------+
| Field      | Type                | Null | Key | Default | Extra          |
+------------+---------------------+------+-----+---------+----------------+
| booking_id | bigint(20) unsigned | NO   | PRI | NULL    | auto_increment |
| fk_car_id  | bigint(20) unsigned | NO   | MUL | NULL    |                |
| from_date  | date                | YES  |     | NULL    |                |
| to_date    | date                | YES  |     | NULL    |                |
+------------+---------------------+------+-----+---------+----------------+
4 rows in set (0.00 sec)