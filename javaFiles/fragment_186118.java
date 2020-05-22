SELECT cols.column_name
  FROM all_constraints cons,
  all_cons_columns   cols
  WHERE (cols.table_name = 'TABLE_NAME'
    AND cols.column_Name = 'SRC_CODE'
    AND cons.constraint_type = 'P'
    AND cons.constraint_name = cols.constraint_name
    AND cons.owner = cols.owner
    AND cons.status = 'ENABLED'
    AND lower(cons.owner) = 'resmaid')
 ORDER BY cols.table_name;