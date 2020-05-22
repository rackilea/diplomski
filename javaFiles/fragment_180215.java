drop table table1;
create table table1(a number, b number, c number, d number, score number);

insert into table1
select  1,      40,      10,       3,     -20 from dual union all
select  0,      40,      2,        3,      10 from dual union all
select  0,      10,      3,        3,      20 from dual union all
select  1,      15,      3,        3,     -5  from dual union all
select  0,      10,      2,        2,     -15 from dual union all
select  0,      15,      6,        3,     -10 from dual;