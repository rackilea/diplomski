SELECT columnA, ColumnB 
FROM table 
WHERE 
  some_filters
  AND $P!{MyParam_SQL}
  AND some_other_stuff