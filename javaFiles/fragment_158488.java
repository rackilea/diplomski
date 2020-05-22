SELECT select_list 
    FROM table1 t_alias1 
    WHERE expr operator 
        (SELECT column_list 
            FROM table2 t_alias2 
            WHERE t_alias1.column 
               operator t_alias2.column);