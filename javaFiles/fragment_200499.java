with words(id, word, rest, lev) as (
      select column1 as id,
             substr(column2, 1, instr(column2, ' ') - 1) as word,
             substr(column2, instr(column2, ' ') + 1) as rest,
             1 as lev
      from table1
      union all
      select id,
             (case when rest like '% %'
                   then substr(rest, 1, instr(rest, ' ') - 1)
                   else rest
              end) as word,
             (case when rest like '% %'
                   then substr(rest, instr(rest, ' ') + 1)
              end) as rest,
             lev + 1
      from words
      where rest is not null
     )
select w.id,
       listagg(coalesce(cast(t2.id as varchar2(255)), w.word), ' ') within group (order by w.lev)
from words w left outer join
     table2 t2
     on w.word = t2.name 
group by w.id;