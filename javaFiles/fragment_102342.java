-- sampe of data from 0 to 3
SQL> with t1(x) as(
  2    select level - 1
  3      from dual
  4    connect by level <= 4
  5  )
  6  select *  -- actual query
  7    from t1
  8   order by case x
  9              when 0 then 'expire'
 10              when 1 then 'approval'
 11              when 2 then 'pending'
 12              when 3 then 'counting'
 13            end
 14  ;
         X
----------
         1
         3
         0
         2