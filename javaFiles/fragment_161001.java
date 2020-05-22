select ar.mid, mar.max_avg
from (
    select mid, 
           avg(rating) as avg_rating
    from rating
    group by mid
  ) as ar
  join (
    select max(avg_rating) as max_avg
    from (
      select avg(rating) as avg_rating
      from rating
      group by mid
    ) as t
  ) as mar
  on ar.avg_rating = mar.max_avg;