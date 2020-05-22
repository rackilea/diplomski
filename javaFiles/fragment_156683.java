insert into table2(user_id, o54879, o54880, . . .)
    select user_id,
           max(object_id = 54879),
           max(object_id = 54880),
           . . . 
    from logs
    group by user_id;