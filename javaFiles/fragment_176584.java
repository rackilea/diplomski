create or replace function my_func(_params text[]) 
returns table (field1 text, field2 text) 
language sql as 
$$
select
  t.field1 as field1,
  t.field2 as field2,
from
  my_table t
where
  array_length(_params, 1) is null or t.foo = any(_params);
$$;