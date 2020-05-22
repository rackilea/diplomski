create function my_random_value(p_seed in number default null)
return number is
begin
  if p_seed is not null then
    dbms_random.seed(p_seed);
  end if;
  return dbms_random.value;
end;
/