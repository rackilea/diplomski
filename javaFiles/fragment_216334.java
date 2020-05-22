PREFIX skos-xl: <http://www.w3.org/2008/05/skos-xl#>
PREFIX skos: <http://www.w3.org/2004/02/skos/core#>

SELECT ?concept ?conceptLabel ?broaderConcept ?broaderConceptLabel WHERE {

  # set the search term
  VALUES ?conceptLabel {"rabbits"@en}

  # get the concept matching the term
  ?concept skos-xl:prefLabel ?conceptLabelNode .
  ?conceptLabelNode skos-xl:literalForm ?conceptLabel .

  # get the broader concepts
  ?concept skos:broader ?broaderConcept.

  # and their labels
  ?broaderConcept skos-xl:prefLabel ?broaderConceptLabelNode .
  ?broaderConceptLabelNode skos-xl:literalForm ?broaderConceptLabel .

  # in English language only
  FILTER(LANGMATCHES(LANG(?broaderConceptLabel), 'en'))
}