delimiter %%
drop procedure if exists getUserId %%
create procedure getUserId( p_name varchar(100) )
begin
  SELECT id, username FROM users
  WHERE username = p_name;
end;%%
delimiter ;