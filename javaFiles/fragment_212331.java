create table album (
    id bigint primary key, -- this field was missing
    title text,
    dateofrelease date,
    coverpath text,
    hours int,
    minutes int,
    seconds int
);