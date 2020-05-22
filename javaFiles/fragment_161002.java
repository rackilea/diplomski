select *
from (
  select mid, 
         avg(rating) as avg_rating,
         dense_rank() over (order by avg(rating) desc) as rnk
  from rating
  group by mid
) t
where rnk = 1;