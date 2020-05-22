insert into event (state, datetime, product_id)
    select 'AVAILABLE', current_timestamp, product_id
    from event e
    where e.state = 'PROCESSED' and
          not exists (select e2.state
                      from event e2
                      where e2.product_id = e.product_id and
                            e2.id > e.id  -- you can use timestamp
                     );