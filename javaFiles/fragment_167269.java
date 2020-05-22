create table student (stu_id number, stu_name varchar2(10), branch varchar2(5), year number);

insert into student (stu_id, stu_name, branch, year) values (1, 'xyz', 'mech', 2);
insert into student (stu_id, stu_name, branch, year)values (2, 'abc', 'cs', 2);
insert into student (stu_id, stu_name, branch, year)values (3, 'efg', 'cs', 2);

commit;