declare
x Clob;

begin
  MyClob(x);
  dbms_output.put_line('created CLOB length = ' || dbms_lob.getlength(x));
end;
/

created CLOB length = 9