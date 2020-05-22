create function is_void(p_text text) returns void
  language plpgsql as
'begin
end';

do $$
begin
  perform is_void('one');
end
$$;