CREATE OR REPLACE TYPE MY_TEST_REC AS OBJECT (
 id_ varchar2(30),
 name_ varchar2(30)
);

CREATE TABLE MY_TEST OF MY_TEST_REC;

create or replace package my_p is
  procedure proc(arg_  IN OUT MY_TEST_REC);
END;

create or replace package body my_p is
  procedure proc(arg_  IN OUT MY_TEST_REC)
  IS  
  BEGIN
    arg_.name_ := 'BAR';
  END;
END;