select distinct ?abstract where {
  values ?name { "New York"@en }
  [ rdfs:label ?name ;
    dbpedia-owl:abstract ?abstract ]
  filter langMatches(lang(?abstract),'en')
}