$ with HOLD (HOLD_ID, MISC_ID, RULE_ID, READY)
as (values
    (1,1,1,1),
    (2,1,2,1),
    (3,1,3,1),
    (4,2,4,0),
    (5,2,1,1)
)

select MISC_ID
from HOLD

group by MISC_ID
having min(READY) <> 0;

 misc_id
---------
       1
(1 row)