prefix rdfs:  <http://www.w3.org/2000/01/rdf-schema#>
prefix owl:   <http://www.w3.org/2002/07/owl#>
prefix rdf:   <http://www.w3.org/1999/02/22-rdf-syntax-ns#>

select ?subclass ?superclass where {
  { ?subclass rdfs:subClassOf ?superclass }
  union
  { ?subclass rdfs:subClassOf [ owl:intersectionOf [ rdf:rest* [ rdf:first ?superclass ] ] ] }
}