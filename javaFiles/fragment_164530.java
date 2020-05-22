drop table test;

create table test(
  id bigint auto_increment primary key, 
  name varchar(255));

insert into test 
select x, 'Hello ' || x from system_range(50, 1200);

select * from test t, system_range(1, 100) range
where t.id = x * (select max(id)-min(id) from test) / 100 + 
(select min(id) from test);