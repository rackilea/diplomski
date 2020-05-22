SELECT a.NAME
    ,a.age
FROM tableA a
WHERE (
        a.NAME
        ,coalesce(a.age, - 1)
        ) NOT IN (
        SELECT b.NAME
            ,coalesce(b.age, - 1)
        FROM tableB b
        );