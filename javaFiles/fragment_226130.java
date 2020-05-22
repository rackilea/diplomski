with my_data(number_value) as
  (
    select 999999999999 from dual
    union 
    select 9 from dual
    union
    select .009 from dual
    union
    select .9 from dual
    union
    select 999 from dual
  )
  select to_char(number_value,'FM'||LPAD(9,38,9)||'.90') from my_data;