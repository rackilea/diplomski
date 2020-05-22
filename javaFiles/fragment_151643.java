CREATE OR REPLACE TRIGGER Table2
AFTER INSERT ON Table1 REFERENCING NEW AS NEW OLD AS OLD
FOR EACH ROW 
BEGIN
  insert into Table2 values (:new.some_col, :new.some_col2, <other columns>);
END;