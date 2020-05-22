select vtm.*, 
  (
    select count(*) 
    from VW_Detail vtc 
    inner join VW_Master vtm2 on vtc.event_id = vtm2.event_id
    where vtc.user_id = vtm.user_id and vtc.provider_id = vtm.provider_id and vtm2.status = 'CLOSE'
  )
from VW_Master vtm
where vtm.status = 'OPEN' or vtm.status = 'PEND';