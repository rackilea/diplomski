do 
$$
declare
bytes bytea;
begin
bytes := num_to_bytea(1677259342285725925376::numeric);
for i in 0..length(bytes)-1 loop
 raise notice '%',  case when get_byte(bytes,i) > 127 then get_byte(bytes,i)-256 else get_byte(bytes,i) end ;
end loop;
end; $$