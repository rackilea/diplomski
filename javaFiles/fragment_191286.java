create table tab (
  id number(7)
);
/

insert into tab values (1);
insert into tab values (2);

create or replace package pkg
as
  type typ is table of tab%rowtype;
end pkg;
/

create or replace procedure proc (param out pkg.typ) as 
begin
  select * bulk collect into param from tab;
end;
/

create or replace function func return pkg.typ pipelined as
begin
  for rec in (select * from tab) loop
    pipe row(rec);
  end loop;
end;
/

select * from table(func);