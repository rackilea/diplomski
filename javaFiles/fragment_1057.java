select id as {u.id},
       userId as {u.userId}, 
       sum(totalSearchedFields) as total, 
       date as {u.date}, 
       status as {u.status}
from user u;