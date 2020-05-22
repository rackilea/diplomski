create or replace function insert_customers(text[])
returns void language plpgsql as $$  
begin
    truncate table customers;
    insert into customers (customerid, customername)
    select cols[1], cols[2]
    from (
        select (ordinality- 1)/2, array_agg(unnest) cols
        from unnest($1) with ordinality
        group by 1
        ) s;
end $$;

select insert_customers('{"id1", "name1", "id2", "name2"}');