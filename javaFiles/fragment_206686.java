hive> from students s join (select avg(score)as avg from students) a
> select s.firstname,
> case
> when s.score="" or s.score=NULL then  cast(avg AS string)
> else s.score
> end as new_score ;