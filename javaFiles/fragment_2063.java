SELECT ?post WHERE {
    ?post a urn:ex:Question .
    ?post urn:ex:dateSubmitted ?date .
}
ORDER BY ?date
LIMIT 1