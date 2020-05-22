with t as (
  select 'dot 1' as val from dual
  union all select 'dot 1 ' as val from dual
  union all select ' dot 1' as val from dual
  union all select ' dot 1 ' as val from dual
  union all select 'dot 4098' as val from dual
  union all select 'dot 4098 ' as val from dual
  union all select ' dot 4098' as val from dual
  union all select ' dot 4098 ' as val from dual
  union all select 'dot 4099' as val from dual
  union all select 'dot 5000' as val from dual
  union all select 'dot 1211' as val from dual
  union all select ' dot 1211 ' as val from dual
  union all select 'x dot 1211 ' as val from dual
  union all select ' dot 1211 x' as val from dual
)
select '<' || val || '>' as val,
  case when regexp_like(val,
    '^\W*dot\s([1-9]|[1-9][0-9]|[1-9][0-9][0-9]|[1-3][0-9][0-9][0-9]|40[0-8][0-9]|409[0-8])\W*$'
    ) then 'Yes' else 'No' end as matches
from t;