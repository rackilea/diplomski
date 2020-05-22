ksql> DESCRIBE CUSTOMERS_WITH_ADDRESSES;

Name                 : CUSTOMERS_WITH_ADDRESSES
 Field        | Type
------------------------------------------
 ROWTIME      | BIGINT           (system)
 ROWKEY       | VARCHAR(STRING)  (system)
 CUSTOMER_ID  | INTEGER          (key)
 FULL_NAME    | VARCHAR(STRING)
 FIRST_NAME   | VARCHAR(STRING)
 ADDRESS_TYPE | VARCHAR(STRING)
 LAST_NAME    | VARCHAR(STRING)
 STREET       | VARCHAR(STRING)
 CITY         | VARCHAR(STRING)
 STATE        | VARCHAR(STRING)
 ZIP          | VARCHAR(STRING)
------------------------------------------
For runtime statistics and query details run: DESCRIBE EXTENDED <Stream,Table>;