-- Convert a variable number of text arguments to text array
-- Used to convert Java collection to the text array
--
create or replace function list_to_array(variadic _list text[]) returns text[] language sql as $$
select _list;
$$;