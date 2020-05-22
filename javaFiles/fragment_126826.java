select tm, sum(isstart) as numstarts, sum(isstop) as numstops,
       (sum(sum(isstart)) over (order by tm nulls last) -
        sum(sum(isstop)) over (order by tm nulls last)
       ) as NumConcurrent
from ((select start_tm as tm, 1 as isstart, 0 as isstop from events
      ) union all
      (select stop_tm, 0 as isstart, 1 as isstop from events
      )
     ) e
group by tm;