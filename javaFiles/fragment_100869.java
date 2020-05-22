create table if not exists tim (
    dummy int, 
    start bigint, 
    id text, 
    cid int, 
    primary key (dummy, start)
);