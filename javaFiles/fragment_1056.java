select u.id as id, 
       u.userId as userId, 
       sum(u.totalSearchedFields) as total, 
       u.date as date, 
       u.status as status 
from user u;