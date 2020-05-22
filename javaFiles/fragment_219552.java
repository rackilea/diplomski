select place, count(*)
from (select distinct on (vehicle_id) dt.*
      from public.datatable dt
      where time >= '2016-09-01 10:00:00' and time < '2016-09-01 11:00:00'
      order by vehicle_id, time
     ) v
group by place;