SELECT ?label ?thumbnail
WHERE {
    <http://dbpedia.org/resource/Harry_Potter>
        dbo:abstract ?label ; 
        dbo:thumbnail ?thumbnail .
    FILTER (lang(?label) = 'en')
}