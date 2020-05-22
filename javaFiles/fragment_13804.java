create or replace procedure getUserId( p_name varchar2, p_ref OUT sys_refcursor )
is
begin
  open p_ref for
     select id, username from users
     where username = p_name;
end;
/