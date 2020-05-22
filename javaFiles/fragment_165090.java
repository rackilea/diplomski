CREATE TABLE My_Table(my_column varchar(255) 
    check (my_column in ('first', 'second', 'last')));

-- fails:
insert into My_Table values('x');

-- ok:
insert into My_Table values('first');