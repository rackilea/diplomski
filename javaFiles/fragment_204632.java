SELECT DUMP( date_column ),
       TO_CHAR( date_column, 'YYYY-MM-DD' ) AS value,
       TO_CHAR( EXTRACT( YEAR FROM date_column ), 'fm00000' )
         || '-' || TO_CHAR( EXTRACT( MONTH  FROM date_column ), 'fm00' )
         || '-' || TO_CHAR( EXTRACT( DAY    FROM date_column ), 'fm00' )
         || ' ' || TO_CHAR( EXTRACT( HOUR   FROM CAST( date_column AS TIMESTAMP ) ), 'fm00' )
         || ':' || TO_CHAR( EXTRACT( MINUTE FROM CAST( date_column AS TIMESTAMP ) ), 'fm00' )
         || ':' || TO_CHAR( EXTRACT( SECOND FROM CAST( date_column AS TIMESTAMP ) ), 'fm00' )
         AS full_value
FROM table_name;