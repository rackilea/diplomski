t=# with a("Data") as (values('a|b|c'||chr(10)||'d|e|f'))
, mid as (select unnest(string_to_array("Data",chr(10))) u from a)
select split_part(u,'|',1) x, split_part(u,'|',2) y, split_part(u,'|',3) z from mid;
 x | y | z
---+---+---
 a | b | c
 d | e | f
(2 rows)