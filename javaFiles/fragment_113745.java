select s.* from scores s 
join 
( select categoryID,max(date_time) as maxdt 
  from scores 
  group by categoryId 
) inr 
on inr.categoryID=s.categoryID and inr.maxdt=s.date_time 
order by s.date_time desc 
limit 4; 

+----+------------+----------------+---------------------+
| id | categoryID | relevanceScore | date_time           |
+----+------------+----------------+---------------------+
|  4 | EC         |         8.0876 | 2015-08-26 14:59:53 |
|  1 | AD         |            110 | 2015-08-26 14:59:51 |
|  2 | DC         |            110 | 2015-08-26 14:59:51 |
|  3 | DO         |            110 | 2015-08-26 14:59:51 |
+----+------------+----------------+---------------------+
4 rows in set (0.00 sec)