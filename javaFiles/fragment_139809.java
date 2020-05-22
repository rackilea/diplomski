PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>
SELECT ?subject ?fsn
WHERE {
  ?subject rdfs:label ?fsn.
  ?subject rdfs:subClassOf+ <http://snomed.info/id/410607006>
}