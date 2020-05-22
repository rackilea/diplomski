select * from (
    select ROWNUM as row_num, b.* from (
        select ROWNUM, MY_TIMESTAMP 
        from T_MY_TABLE 
        where MY_TIMESTAMP < TIMESTAMP'2015-01-20 12:12:34'
        and ROWNUM <= 200
        order by MY_TIMESTAMP desc
    ) b 
) where row_num > 100;