with t as (
  select rawtohex(sys_guid()) guid from dual
  connect by level <= 3
)
select guid, lower(substr(guid, 1, 8)
  ||'-'|| substr(guid, 9, 4)
  ||'-'|| substr(guid, 13, 4)
  ||'-'|| substr(guid, 17, 4)
  ||'-'|| substr(guid, 21, 12)) as formatted_guid
from t;


GUID                             FORMATTED_GUID                     
-------------------------------- ------------------------------------
993712381A8543FB9320C587D078330E 99371238-1a85-43fb-9320-c587d078330e 
FFF3CF7104E048BF8E6677B080BD35A6 fff3cf71-04e0-48bf-8e66-77b080bd35a6 
1FBCC67EA46B4474B26128F2DDAA519B 1fbcc67e-a46b-4474-b261-28f2ddaa519b