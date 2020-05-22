SQL> CREATE OR REPLACE PROCEDURE insert_new_address (
  2     account_array IN ACCOUNT_OBJ_ARRAY
  3     ) AS
  4     tempaddres NEW_ADDRS_OBJ_ARRAY;
  5  BEGIN
  6     FOR i IN 1 .. account_array.COUNT LOOP
  7        FOR j IN 1 .. account_array(i).newAddress.COUNT LOOP
  8           dbms_output.put_line(
  9              account_array(i).fname || ', ' || 
 10              account_array(i).newAddress(j).newAddress1 || ', ' || 
 11              account_array(i).newAddress(j).newAddress2 || ', ' || 
 12              account_array(i).newAddress(j).city || ', ' || 
 13              account_array(i).newAddress(j).state || ', ' || 
 14              account_array(i).newAddress(j).zip);
 15        END LOOP;
 16     END LOOP;
 17  END;
 18  /

Procedure created