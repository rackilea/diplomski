create table myclass (
    id int8 not null,
    primary key (id)
);
create table myclass_mysubclass (
    myclass_id int8 not null,
    mysubclass_id int4
);