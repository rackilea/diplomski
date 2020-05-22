select t1.workitemid, count(1) as ptwNumRows
    , (select count(1) ct from WHT t2 where t2.workitemid = t1.workitemid) as pttdNumRows
    , (select count(1) ct from FX t3 where t3.workitemid = t1.workitemid)   as ptsiNumRows
from TRANSACTION t1
where t1.workitemid = '104854'
order by t1.workitemid;