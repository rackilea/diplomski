prefix rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>
prefix sumo: <http://www.ontologyportal.org/SUMO.owl#>
select ?city where { 
  ?city rdf:type sumo:City .
  ?city sumo:geographicSubregion sumo:Spain .
}