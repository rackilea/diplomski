select t.*
from (select t.*, (@rn := @rn + 1) as rn
      from t cross join
           (select @rn := 0) params
      order by topics, taxonomy
     ) t cross join
     (select count(*) as cnt from t) tt
where rn % floor(cnt / 6) = 1;