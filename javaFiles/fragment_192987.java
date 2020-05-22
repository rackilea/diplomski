with times as (
      select starttime as t, +1 as inc
      from structure
      union all
      select endtime, -1
      from structure
     )
select t.*
from (select t, sum(inc) over (order by t) as actives
      from (select t, sum(inc) as inc
            from times
            group by t
           ) t
      order by actives desc
    ) t
where rownum = 1;