CREATE TABLE table_name ( date_column DATE );

INSERT INTO table_name ( date_column )
VALUES ( DATE '2019-12-31' + INTERVAL '1:02:03' HOUR TO SECOND );

INSERT INTO table_name ( date_column ) VALUES ( createDate( 15599, 12, 31, 1, 2, 3 ) );

INSERT INTO table_name ( date_column ) VALUES ( createDate( 12017, 2, 21, 0, 0, 0 ) );