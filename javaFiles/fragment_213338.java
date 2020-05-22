create table test(id int, dt datetime);

    insert into test(id, dt) values (1, CURDATE());

    insert into test(id, dt) values (2, NULL);

    insert into test(id, dt) values (3, NOW());

    insert into test(id, dt) values (4, NULL);


    select
    id, coalesce(dt, '') as dt
    from
    test;