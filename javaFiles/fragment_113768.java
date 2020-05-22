$ qparse --query query.rq # the original query, warnigns
14:12:22 WARN  NodeValue            :: Datatype format exception: "2014-06-05T10:10:10+0530"^^xsd:dateTime
14:12:22 WARN  NodeValue            :: Datatype format exception: "2014-06-05T10:10:10+0530"^^xsd:dateTime
14:12:22 WARN  NodeValue            :: Datatype format exception: "2014-06-05T10:10:10+0530"^^xsd:dateTime
PREFIX  xsd:  <http://www.w3.org/2001/XMLSchema#>

SELECT  ?x
WHERE
  { ?y <DATE:> ?x
    FILTER ( ?x > "2014-06-05T10:10:10+0530"^^xsd:dateTime )
  }