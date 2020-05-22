(?i)
    \b 
    (?:
         CONTAINS
      |  IN
      |  SELECT
      |  FROM
      |  WHERE
    )
    (?:
         /
         (?:
              CONTAINS
           |  IN
           |  SELECT
           |  FROM
           |  WHERE
         )
    )*
    \b 
 |  ( this\. )                    # (1)
 |  [(){}=,] 
 |  ( \s{2,} )                    # (2)