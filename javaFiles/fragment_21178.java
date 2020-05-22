SELECT a.NAME
    ,a.age
FROM tableA a
WHERE (
        a.NAME
        ,coalesce(a.age, 0)
        ) NOT IN (
        SELECT b.NAME
            ,coalesce(b.age, 0)
        FROM tableB b
        );