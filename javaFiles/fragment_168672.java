MERGE INTO some_table ut
USING (
  VALUES
    ('foo', 'bar')
) AS md (foo_column, bar_column) ON (ut.foo_column = md.foo_column)
WHEN MATCHED THEN UPDATE
     SET ut.bar_column = md.bar_column
WHEN NOT MATCHED THEN
  INSERT (foo_column, bar_column)
  VALUES (md.foo_column, md.bar_column);