ksql> CREATE STREAM CUSTOMERS_KEYED WITH (PARTITIONS=1) AS SELECT * FROM CUSTOMERS_RAW PARTITION BY ID;

 Message
----------------------------
 Stream created and running
----------------------------