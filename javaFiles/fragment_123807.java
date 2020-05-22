select roomnumber, roomtypeid
from rooms 
where roomnumber not in 
(
  select roomnumber 
  from booking 
  where departure >= to_date(? /* desired arrival date */, 'yyyy-mm-dd')
  and arrival <= to_date(? /* desired departure date */, 'yyyy-mm-dd')
)
and roomtypeid = ? /* desired room type */
order by roomnumber;