SELECT col1, col5, col6
FROM (SELECT v.*,
             MAX(col5) OVER (PARTITION BY col1) as max_col5
      FROM TABLE v
      WHERE v.col1 = 'value' AND
            (v.col2 = 'bla' OR v.col3 = 'blabla' OR v.col4 = 'blaDiff')
     ) v
WHERE v.col5 = v.max_col5;