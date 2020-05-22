SQL> DECLARE
  2     l_prodtable prodtable := prodtable();
  3  BEGIN
  4     l_prodtable.extend(2);
  5     l_prodtable(1) := prod_obj(1, 'Prod A', '', '', '', '', '');
  6     l_prodtable(2) := prod_obj(2, 'Prod B', '', '', '', '', '');
  7     FOR i IN 1 .. 2 LOOP
  8        INSERT INTO fornecprods VALUES (fornec_obj(i, 'Forn '||i, '',
  9                                                   '', '', '', '', ''),
 10                                        l_prodtable);
 11     END LOOP;
 12  END;
 13  /     
PL/SQL procedure successfully completed