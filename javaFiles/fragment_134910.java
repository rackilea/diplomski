CREATE TABLE warehouse (
 time timestamp, 
 person struct<id : int, name: string, organization : string>, 
 activity struct<id : int, name: string>, 
 `case` struct<id : int, name: string, organization : string>
);


INSERT INTO TABLE warehouse
select 
'2018-05-31',
NAMED_STRUCT('id', 1, 'name', 'Alex', 'organization', 'CITI'),
NAMED_STRUCT('id', 1, 'name', 'Buy'),
NAMED_STRUCT('id', 1, 'name', 'Gold', 'organization', 'London') 
FROM (
select '1'
) t 
;