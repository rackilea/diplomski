ksql> CREATE STREAM customers_with_addresses AS 
      SELECT CUSTOMER_ID, 
             FIRST_NAME + ' ' + LAST_NAME AS FULL_NAME, 
             FIRST_NAME, 
             LAST_NAME, 
             TYPE AS ADDRESS_TYPE, 
             STREET, 
             CITY, 
             STATE, 
             ZIP 
        FROM ADDRESSES_RAW A 
             INNER JOIN CUSTOMER C 
             ON A.CUSTOMER_ID = C.ID;

 Message
----------------------------
 Stream created and running
----------------------------