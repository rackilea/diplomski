create function is_void(p_text text) returns void
  language plpgsql as
'begin
end';

select is_void('one');