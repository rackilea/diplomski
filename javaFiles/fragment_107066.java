SQL> BEGIN
  2     FOR cc IN (SELECT supplier, products FROM fornecprods) LOOP
  3        dbms_output.put_line('-----------------------');
  4        dbms_output.put_line('Products list of '
  5                             || cc.supplier.NOME_FORNECEDOR);
  6        dbms_output.put_line('-----------------------');
  7        FOR i IN 1 .. cc.products.count LOOP
  8           dbms_output.put_line('-' || cc.products(i).NOME_PROD);
  9        END LOOP;
 10     END LOOP;
 11  END;
 12  /

-----------------------
Products list of Forn 1
-----------------------
-Prod A
-Prod B
-----------------------
Products list of Forn 2
-----------------------
-Prod A
-Prod B

PL/SQL procedure successfully completed