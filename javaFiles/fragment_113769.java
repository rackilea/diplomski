$ qparse --query query.rq # the updated query, no warnings
PREFIX  xsd:  <http://www.w3.org/2001/XMLSchema#>

SELECT  ?x
WHERE
  { ?y <DATE:> ?x
    FILTER ( ?x > "2014-06-05T10:10:10+05:30"^^xsd:dateTime )
  }