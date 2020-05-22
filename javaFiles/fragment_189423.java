select a.*, t.noOfUser
from teklaevent a
inner join (
  select max(id) maxid, count(distinct userId) noOfUser
  from  teklaevent
  group by projectId
) t on a.id = t.maxid;