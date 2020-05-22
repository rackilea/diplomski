with cte as (
select 1, case when exists (select null from foo where bar = 1) then 'Y' else 'N' end from dual
union all
select 2, case when exists (select null from foo where bar = 2) then 'Y' else 'N' end from dual
union all
...
)
select * from cte;