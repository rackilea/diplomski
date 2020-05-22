-- Convert the bytea argument to null.
-- Used to convert Java null to PostgreSQL null
--
create or replace function list_to_array(_list bytea) returns text[] language sql as $$
select null::text[];
$$;