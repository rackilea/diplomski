ksql> CREATE STREAM addresses_RAW (ID INT, CUSTOMER_ID INT, STREET VARCHAR, CITY VARCHAR, STATE VARCHAR, ZIP VARCHAR, TYPE VARCHAR) WITH (KAFKA_TOPIC='addresses', VALUE_FORMAT='JSON');

 Message
----------------
 Stream created
----------------

ksql> CREATE STREAM customers_RAW (ID INT, FIRST_NAME VARCHAR, LAST_NAME VARCHAR, EMAIL VARCHAR) WITH (KAFKA_TOPIC='customers', VALUE_FORMAT='JSON');

 Message
----------------
 Stream created
----------------