SELECT ?abstract ?cleanAbstract
WHERE {
  dbpedia:Mitsubishi dbpedia-owl:abstract ?abstract 
  FILTER langMatches( lang(?abstract), 'en')
  bind(replace(?abstract,"[^\\x{0000}-\\x{024f}]","") as ?cleanAbstract)
}