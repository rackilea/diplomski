select cols[1], cols[2]
from (
    select (ordinality- 1)/2, array_agg(unnest) cols
    from unnest('{"id1", "name1", "id2", "name2"}'::text[]) with ordinality
    group by 1
    ) s

 cols | cols  
------+-------
 id1  | name1
 id2  | name2
(2 rows)