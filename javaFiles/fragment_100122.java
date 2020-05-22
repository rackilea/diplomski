select number, count(*)
from (
  select substring(n, 1, 2) as number
  from l  
  union all  
  select substring(n, 4, 2)
  from l  
  union all  
  select substring(n, 7, 2)
  from l
  ) a
group by number;