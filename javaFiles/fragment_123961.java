create or replace directory data_dir as '/mydatadir/';
create table external_table (
  id number(18),
  name varchar2(30),
  otherfield1 varchar2(40),
  otherfield2 varchar2(40))
organization external (
  type oracle_loader
  default directory data_dir
  access parameters
  ( fields terminated by ',' )
  location ('mydata.csv')
)