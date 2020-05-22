create or replace trigger logon_trg
  after logon on database
begin
    if (user = 'PRODUCTS_READONLY') then
      execute immediate 'alter session set current_schema = products';
    end if;
exception
  when others then null; -- prevent a login failure due to an exception
end logon_trg;
/