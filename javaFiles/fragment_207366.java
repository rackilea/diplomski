create procedure MY_PROC 
  @ARG1 varchar(10)
as
begin
  select * from users where name = @ARG1;
end